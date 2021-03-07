import com.pinko.dependencies.Plugins
import com.pinko.dependencies.Repositories
import com.pinko.dependencies.Plugins.PluginSpec

/**
 * The buildscript block is where you configure the repositories and
 * dependencies for Gradle itself—meaning, you should not include dependencies
 * for your modules here. For example, this block includes the Android plugin for
 * Gradle as a dependency because it provides the additional instructions Gradle
 * needs to build Android app modules.
 */
buildscript {

  /**
   * The repositories block configures the repositories Gradle uses to
   * search or download the dependencies. Gradle pre-configures support for remote
   * repositories such as Maven Central, and Ivy. You can also use local
   * repositories or define your own remote repositories.
   */

  repositories {
    google()
    mavenCentral()
    maven(com.pinko.dependencies.Repositories.gradle)
    maven(com.pinko.dependencies.Repositories.androidAnalyzer)
  }

  dependencies {
    /** Helper function to create a dependency with an explanation. */
    fun DependencyHandler.classpathWithBecause(pluginSpec: com.pinko.dependencies.Plugins.PluginSpec): ExternalModuleDependency =
      add(
        ScriptHandler.CLASSPATH_CONFIGURATION, pluginSpec.classPath
      ) { because(pluginSpec.because) }

    classpathWithBecause(com.pinko.dependencies.Plugins.AndroidPlugin)

    classpathWithBecause(com.pinko.dependencies.Plugins.AndroidPlugin)
    classpathWithBecause(com.pinko.dependencies.Plugins.KotlinPlugin)

    // Kotlin serialization
    classpathWithBecause(com.pinko.dependencies.Plugins.KotlinSerialization)

    // Junit5 for Android plugin
    classpathWithBecause(com.pinko.dependencies.Plugins.Junit5Android)

    // Benchmark lock clock
    classpathWithBecause(com.pinko.dependencies.Plugins.Benchmark)

    // Android code analyzer
    classpathWithBecause(com.pinko.dependencies.Plugins.AndroidAnalyzer)

    // check dependency vulnerability
    classpathWithBecause(com.pinko.dependencies.Plugins.DependencyCheck)

    // check dependency version upgrade
    classpathWithBecause(com.pinko.dependencies.Plugins.Versions)
  }
}

/**
 *
 */

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
