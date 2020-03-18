const val kotlinVersion = "1.3.70"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "4.1.0-alpha02"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"

}

object AndroidSdk {
    const val buildTools = "29.0.2"
    const val min = 21
    const val compile = 29
    const val target = compile
}

object Libraries {
    private object Versions {
        const val jetpack = "1.2.0-alpha03"
        const val constraintLayout = "2.0.0-beta4"
        const val ktx = "1.3.0-alpha02"
        const val compose = "0.1.0-dev06"
    }

    const val kotlinStdLib          = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat             = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout      = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore               = "androidx.core:core-ktx:${Versions.ktx}"

    const val androidxUiFramework   = "androidx.ui:ui-framework:${Versions.compose}"
    const val androidxUiLayout      = "androidx.ui:ui-layout:${Versions.compose}"
    const val androidxUiMaterial    = "androidx.ui:ui-material:${Versions.compose}"
    const val androidxUiTooling     = "androidx.ui:ui-tooling:${Versions.compose}"

    const val composeRuntime        = "androidx.compose:compose-runtime:${Versions.compose}"
}

object Logging {
    private const val kotlinLoggingVersion = "1.7.8"

    const val kotlinLogging         = "io.github.microutils:kotlin-logging:$kotlinLoggingVersion"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.13"
        const val testRunner = "1.3.0-alpha5"
        const val espresso = "3.3.0-alpha5"
    }
    const val junit4     = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso   = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}