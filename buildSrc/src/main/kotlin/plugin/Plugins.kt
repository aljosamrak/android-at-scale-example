package plugin

/**
 * Created by Aljoša Mrak on 17.3.2020.
 */
object Plugins {

    /**
     * Kotlin serialization support
     */
    object Kapt {
        const val plugin: String = "kapt"
    }

    /**
     * Kotlin serialization support
     */
    object KotlinSerialization {
        const val version: String = Kotlin.kotlinVersion
        const val classPath: String = "org.jetbrains.kotlin:kotlin-serialization:$version"
        const val because: String = "Kotlin JSON serialization"
        const val plugin: String = "plugin.serialization"
    }

    /**
     * To lock your clocks, add the supplied helper plugin to the top level project’s classpath in the main build.gradle file:
     * </p>
     * Add tasks <code>./gradlew lockClocks</code> and <code>./gradlew unlockClocks</code>
     * </p>
     * @see <a href="https://developer.android.com/studio/profile/benchmark#clock-stability">benchmark lock clock</a>
     */
    object Benchmark {
        const val version: String = "1.0.0-beta01"
        const val classPath: String = "androidx.benchmark:benchmark-gradle-plugin:$version"
        const val because: String = "dependencycheck plugin - provides monitoring of the projects dependent libraries"
        const val plugin: String = "androidx.benchmark"
    }

    /**
     * Provides monitoring of the projects dependent libraries; creating a report of
     * known vulnerable components that are included in the build.
     * </p>
     * @see <a href="https://jeremylong.github.io/DependencyCheck/dependency-check-gradle/index.html">dependency-check-gradle</a>
     */
    object DependencyCheck {
        const val version: String = "5.3.1"
        const val classPath: String = "org.owasp:dependency-check-gradle:$version"
        const val because: String = "dependencycheck plugin - provides monitoring of the projects dependent libraries"
        const val plugin: String = "org.owasp.dependencycheck"
    }

    /**
     * This plugin provides a task to determine which dependencies have updates. Additionally,
     * the plugin checks for updates to Gradle itself.
     * </p>
     * @see <a href="https://github.com/ben-manes/gradle-versions-plugin">gradle-version-plugin</a>
     */
    object Versions {
        const val version: String = "0.28.0"
        const val classPath: String = "com.github.ben-manes:gradle-versions-plugin:$version"
        const val because: String = "this plugin provides a task to determine which dependencies have updates. Additionally, the plugin checks for updates to Gradle itself."
        const val plugin: String = "com.github.ben-manes.versions"
    }
}