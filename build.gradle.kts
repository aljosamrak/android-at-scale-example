import org.jetbrains.kotlin.konan.properties.hasProperty

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
        maven(Repositories.kotlinEap)
    }
    dependencies {
        classpath (BuildPlugins.androidGradlePlugin)
        classpath (BuildPlugins.kotlinGradlePlugin)
    }
}

/**
 *
 */
plugins {
//    base
//    kotlin("jvm") version "1.3.21" apply false

// https://developer.android.com/studio/test/command-line#multi-module-reports TODO
//    id("android-reporting")
//    jacoco
//    id("com.gradle.build-scan") version Config.Versions.buildScanVersion
    id("org.sonarqube") version "2.8"
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
    }
}

subprojects {
//    dependencies {
//        testCompile 'junit:junit:4.11'
//    }
//
//    jacocoTestReport {
//        additionalSourceDirs = files(sourceSets.main.allSource.srcDirs)
//        sourceDirectories = files(sourceSets.main.allSource.srcDirs)
//        classDirectories =  files(sourceSets.main.output)
//        reports {
//            html.enabled = true
//            xml.enabled = true
//            csv.enabled = false
//        }
//    }

//    sonarqube {
//        properties {
//            property("sonar.sources", "src")
//        }
//    }
}


val rootProperties = readProperties(File(project.rootDir, "local.properties"))

//https://sonarcloud.io/dashboard?id=aljosamrak_android-at-scale-example
sonarqube {
    properties {
        property("sonar.projectKey", "aljosamrak_android-at-scale-example")
        property("sonar.organization", "aljosamrak")
        property("sonar.host.url", "https://sonarcloud.io")
        if (rootProperties.hasProperty("sonarQubeKey")) {
            property("sonar.login", rootProperties.getProperty("sonarQubeKey"))
        }
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


// https://gist.github.com/aalmiray/e6f54aa4b3803be0bcac
//task jacocoRootReport(type: org.gradle.testing.jacoco.tasks.JacocoReport) {
//    dependsOn = subprojects.test
//    additionalSourceDirs = files(subprojects.sourceSets.main.allSource.srcDirs)
//    sourceDirectories = files(subprojects.sourceSets.main.allSource.srcDirs)
//    classDirectories =  files(subprojects.sourceSets.main.output)
//    executionData = files(subprojects.jacocoTestReport.executionData)
//    reports {
//        html.enabled = true
//        xml.enabled = true
//        csv.enabled = false
//    }
//}

fun readProperties(propertiesFile: File) = java.util.Properties().apply {
    if (propertiesFile.exists()) {
        propertiesFile.inputStream().use { fis ->
            load(fis)
        }
    }
}