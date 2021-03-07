import com.pinko.dependencies.Plugins
import com.pinko.dependencies.Repositories

/**
 * The buildscript block is where you configure the repositories and
 * dependencies for Gradle itself—meaning, you should not include dependencies
 * for your modules here. For example, this block includes the Android plugin for
 * Gradle as a dependency because it provides the additional instructions Gradle
 * needs to build Android app modules.
 */
buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven(Repositories.kotlinEap)
    }
    dependencies {
        classpath (BuildPlugins.androidGradlePlugin)
        classpath (BuildPlugins.kotlinGradlePlugin)

        // kotlin serialization
        classpath(Plugins.KotlinSerialization.classPath) {
            because(Plugins.KotlinSerialization.because)
        }

        // benchmark lock clock
        classpath(Plugins.Benchmark.classPath) {
            because(Plugins.Benchmark.because)
        }

        // check dependency vulnerability
        classpath(Plugins.DependencyCheck.classPath) {
            because(Plugins.DependencyCheck.because)
        }

        // check dependency version upgrade
        classpath(Plugins.Versions.classPath) {
            because(Plugins.Versions.because)
        }
    }
}

/**
 *
 */
plugins {
//    base
//    kotlin("jvm") version "1.3.21" apply false

    // kotlin serialization
    kotlin(Plugins.KotlinSerialization.plugin) version Plugins.KotlinSerialization.version apply false

    // gradle version plugins
    id(Plugins.DependencyCheck.plugin) version Plugins.DependencyCheck.version apply true
    id(Plugins.Versions.plugin) version Plugins.Versions.version apply true

    jacoco apply true

//    id("com.gradle.build-scan") version Config.Versions.buildScanVersion

    id(Plugins.SonarQube.plugin) version Plugins.SonarQube.version apply true
}

/**
 * The allprojects block is where you configure the repositories and
 * dependencies used by all modules in your project, such as third-party plugins
 * or libraries. However, you should configure module-specific dependencies in
 * each module-level build.gradle file. For new projects, Android Studio
 * includes JCenter and Google's Maven repository by default, but it does not
 * configure any dependencies (unless you select a template that requires some).
 */

allprojects {
    repositories {
        google()
        jcenter()
        maven(Repositories.kotlinEap)
        maven(Repositories.kotlinx)
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    apply(plugin = Plugins.Versions.plugin)

    apply(plugin = Plugins.DependencyCheck.plugin)

    dependencyCheck {
        quickQueryTimestamp = false    // when set to false, it means use HTTP GET method to query timestamp. (default value is true)
        failBuildOnCVSS = 5.0f
        failOnError = true
        suppressionFile = "config/dependencyCheck/suppressions.xml"
        analyzers(closureOf<org.owasp.dependencycheck.gradle.extension.AnalyzerExtension> {
            experimentalEnabled = true
            archiveEnabled = true
            jarEnabled = true
            centralEnabled = true
            nexusEnabled = true
            pyDistributionEnabled = false
            pyPackageEnabled = false
            rubygemsEnabled = false
            opensslEnabled = false
            nuspecEnabled = false
            assemblyEnabled = false
            cmakeEnabled = false
            autoconfEnabled = true
            composerEnabled = false
            nodeEnabled = true
            cocoapodsEnabled = false
            swiftEnabled = false
        })
    }
    tasks.findByName("check")?.dependsOn("dependencyCheckAnalyze")
}

subprojects {
//    dependencies {
//        testCompile 'junit:junit:4.11'
//    }
}

//https://sonarcloud.io/dashboard?id=aljosamrak_android-at-scale-example
sonarqube {
    properties {
        property("sonar.projectKey", "aljosamrak_android-at-scale-example")
        property("sonar.organization", "aljosamrak")
        property("sonar.host.url", "https://sonarcloud.io")
        envOrProperty("SONAR_TOKEN", false)?.let { property("sonar.login", it) }
    }
}

tasks.register("clean").configure {
    delete("build")
}

// https://github.com/rakutentech/android-buildconfig/tree/master/buildSrc
//import com.rakuten.tech.tool.CheckGradleFilesForSnapshotDependencies
//        task preReleaseCheck(type: CheckGradleFilesForSnapshotDependencies) {
//    exclude = [
//    ~/.*\/config\/.*\.gradle/,
//    ~/.*\/buildSrc\/.*\.gradle/,
//    ~/.*\/TestUI\/.*\.gradle/,
//    ]
//}
