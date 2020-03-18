package plugin

/**
 * Created by Aljoša Mrak on 17.3.2020.
 */
object Plugins {

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
     * @see <a href="https://jeremylong.github.io/DependencyCheck/dependency-check-gradle/index.html">dependency-check-gradle</a>
     */
    object Versions {
        const val version: String = "0.28.0"
        const val classPath: String = "com.github.ben-manes:gradle-versions-plugin:$version"
        const val because: String = "this plugin provides a task to determine which dependencies have updates. Additionally, the plugin checks for updates to Gradle itself."
        const val plugin: String = "com.github.ben-manes.versions"
    }
}