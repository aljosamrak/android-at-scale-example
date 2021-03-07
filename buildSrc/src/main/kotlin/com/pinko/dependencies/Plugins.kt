package com.pinko.dependencies

import Kotlin

/**
 * Created by Pinko on 17.3.2020.
 */
object Plugins {

  interface PluginSpec {
    val classPath: String
    val because: String
  }

  /**
   * Kotlin serialization support
   */
  object Kapt {
    const val plugin = "kapt"
  }

  /**
   * Kotlin serialization support
   */
  object AndroidPlugin : PluginSpec {
    override val classPath = "com.android.tools.build:gradle:7.0.0-alpha08"
    override val because = ""
//      get() = TODO("Not yet implemented")
  }

  /**
   * Kotlin serialization support
   */
  object KotlinPlugin : PluginSpec {
    override val classPath = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.kotlinVersion}"
    override val because = ""
//      get() = TODO("Not yet implemented")
  }

  /**
   * Kotlin serialization support
   */
  object KotlinSerialization : PluginSpec {
    override val classPath =
      "org.jetbrains.kotlin:kotlin-serialization:${Kotlin.kotlinVersion}"
    override val because = "Kotlin JSON serialization"
    const val plugin = "plugin.serialization"
  }

  /**
   * To lock your clocks, add the supplied helper plugin to the top level project’s classpath in the main build.gradle file:
   * </p>
   * Add tasks <code>./gradlew lockClocks</code> and <code>./gradlew unlockClocks</code>
   * </p>
   * @see <a href="https://developer.android.com/studio/profile/benchmark#clock-stability">benchmark lock clock</a>
   */
  object Benchmark : PluginSpec {
    override val classPath = "androidx.benchmark:benchmark-gradle-plugin:1.0.0-beta01"
    override val because =
      "dependencycheck plugin - provides monitoring of the projects dependent libraries"
    const val plugin = "androidx.benchmark"
  }

  /**
   * Provides monitoring of the projects dependent libraries; creating a report of
   * known vulnerable components that are included in the build.
   * </p>
   * @see <a href="https://jeremylong.github.io/DependencyCheck/dependency-check-gradle/index.html">dependency-check-gradle</a>
   */
  object DependencyCheck : PluginSpec {
    override val classPath = "org.owasp:dependency-check-gradle:5.3.1"
    override val because =
      "dependencycheck plugin - provides monitoring of the projects dependent libraries"
    const val plugin = "org.owasp.dependencycheck"
  }

  /**
   * This plugin provides a task to determine which dependencies have updates. Additionally,
   * the plugin checks for updates to Gradle itself.
   * </p>
   * @see <a href="https://github.com/ben-manes/gradle-versions-plugin">gradle-version-plugin</a>
   */
  object Versions : PluginSpec {
    override val classPath = "com.github.ben-manes:gradle-versions-plugin:0.38.0"
    override val because =
      "this plugin provides a task to determine which dependencies have updates. Additionally, the plugin checks for updates to Gradle itself."
    const val plugin = "com.github.ben-manes.versions"
  }

  /**
   * This plugin configures the unit test tasks for each build variant of a project to run on the
   * JUnit Platform. Furthermore, it provides additional configuration options for these tests
   * through a DSL attached to android.testOptions.
   * </p>
   * @see <a href="https://github.com/mannodermaus/android-junit5</a>
   */
  object Junit5Android : PluginSpec {
    override val classPath = "de.mannodermaus.gradle.plugins:android-junit5:1.7.1.1"
    override val because =
      "this plugin configures the unit test tasks for each build variant of a project to run on the JUnit Platform."
    const val plugin = "de.mannodermaus.android-junit5"
  }

  /**
   * Android Analyzer is a Gradle plugin for analyzing Android projects, integrating Sonarqube and
   * Detekt for static code analysis and Jacoco for Kotlin and Java code coverage reports. The
   * plugin provides a very easy to use interface and abstracts away the complexity of setting up
   * the two systems manually.
   * </p>
   * @see <a href="https://github.com/pinchbv/android-analyzer</a>
   */
  object AndroidAnalyzer : PluginSpec {
    override val classPath = "com.justpinch:androidanalyzer:1.4.1"
    override val because =
      "Gradle plugin for analyzing Android projects, integrating Sonarqube and Detekt for static code analysis and Jacoco for Kotlin and Java code coverage reports."
  }

  object AndroidApplication {
    const val plugin = "com.android.application"
  }

  object AndroidKotlin {
    const val plugin = "kotlin-android"
  }

  object KotlinKapt {
    const val plugin = "kotlin-kapt"
  }

  object SonarQube : PluginSpec {
    const val version = "2.8"
    const val plugin = "org.sonarqube"
    override val classPath = ""
//      get() = TODO("Not yet implemented")
    override val because = ""
//      get() = TODO("Not yet implemented")
  }
}