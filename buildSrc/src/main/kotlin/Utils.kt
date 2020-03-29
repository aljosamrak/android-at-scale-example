import org.gradle.api.Project
import java.io.File
import java.util.*

/**
 * Created by Aljoša Mrak on 23.3.2020.
 */
object Utils {

    private const val propertiesFileName = "local.properties"

    private val localProperties: Lazy<Properties> = lazy {
        Properties().apply {
            val propertiesFile = File(propertiesFileName)
            if (propertiesFile.exists()) {
                propertiesFile.inputStream().use { fis ->
                    load(fis)
                }
            }
        }
    }

    fun Project.envOrProperty(name: String, required: Boolean = false): String? {
        val result = project.findProperty(name) as? String ?: System.getenv(name) ?: localProperties.value.getProperty(name)
        check(result != null || required.not()) { "Missing required environment property:\n  export $name=\"...\"" }
        return result
    }
}