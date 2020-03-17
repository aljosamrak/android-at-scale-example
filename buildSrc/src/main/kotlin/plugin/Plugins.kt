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
        const val classPath: String = "org.owasp:dependency-check-gradle:5.3.1"
        const val because: String = "dependencycheck plugin - provides monitoring of the projects dependent libraries"
        const val plugin: String = "org.owasp.dependencycheck"
        const val version: String = "5.3.1"
    }
}