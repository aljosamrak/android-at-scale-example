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
  project.tasks.named<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask>("dependencyUpdates").configure {
    outputFormatter = "plain,json,html"
  }

  apply(plugin = Plugins.DependencyCheck.plugin)
}