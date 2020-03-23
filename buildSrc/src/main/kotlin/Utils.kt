import org.gradle.api.Project

/**
 * Created by Aljoša Mrak on 23.3.2020.
 */
object Utils {
    fun Project.envOrProperty(name: String, required: Boolean = false): String? {
        val result = project.findProperty(name) as? String ?: System.getenv(name)
        check(result != null || required.not()) { "Missing required environment property:\n  export $name=\"...\"" }
        return result
    }
}