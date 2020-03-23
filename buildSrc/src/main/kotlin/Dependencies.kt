object Kotlin {
    const val kotlinVersion = "1.3.61"  // 1.3.70 not working - problem with kotlin serialization
}

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "4.1.0-alpha02"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.kotlinVersion}"
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

    const val kotlinStdLib          = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Kotlin.kotlinVersion}"
    const val appCompat             = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout      = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore               = "androidx.core:core-ktx:${Versions.ktx}"

    const val androidxUiFramework   = "androidx.ui:ui-framework:${Versions.compose}"
    const val androidxUiLayout      = "androidx.ui:ui-layout:${Versions.compose}"
    const val androidxUiMaterial    = "androidx.ui:ui-material:${Versions.compose}"
    const val androidxUiTooling     = "androidx.ui:ui-tooling:${Versions.compose}"

    const val composeRuntime        = "androidx.compose:compose-runtime:${Versions.compose}"
}

object IoLibrary {
    private object Versions {
        const val apache    = "1.3.2"
        const val guava     = "r03"
        const val okio      = "1.16.0"
    }

    const val apache        = "org.apache.commons:commons-io:${Versions.apache}"
    const val guava         = "com.google.guava:guava-io:${Versions.guava}"
    const val okio          = "com.squareup.okio:okio:${Versions.okio}"
}

object JsonLibrary {
    private object Versions {
        const val gson                  = "2.8.6"
        const val jackson               = "2.10.2"
        const val moshi                 = "1.9.2"
        const val kotlinSerialization   = "0.11.0"
    }

    const val gson                  = "com.google.code.gson:gson:${Versions.gson}"
    const val jackson               = "com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jackson}"
    const val kotlinSerialization   = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.kotlinSerialization}"
    const val moshi                 = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiCodegen          = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
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
        const val benchmark = "1.0.0"
        const val androidxJunit = "1.1.1"
        const val assertj = "3.11.1"
    }
    const val junit4            = "junit:junit:${Versions.junit4}"
    const val testRunner        = "androidx.test:runner:${Versions.testRunner}"
    const val espresso          = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val androidxBenchmark = "androidx.benchmark:benchmark-junit4:${Versions.benchmark}"
    const val androidxJunit     = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val assertj           = "org.assertj:assertj-core:${Versions.assertj}"
}

object TestInstrumentationRunner {
    const val benchmark = "androidx.benchmark.junit4.AndroidBenchmarkRunner"
}

object Orchid {
    const val version           = "0.19.0"

    const val plugin            = "com.eden.orchidPlugin"
    const val core              = "io.github.javaeden.orchid:OrchidCore:$version"
    const val posts             = "io.github.javaeden.orchid:OrchidPosts:$version"
    const val pages             = "io.github.javaeden.orchid:OrchidPages:$version"
    const val wiki              = "io.github.javaeden.orchid:OrchidWiki:$version"
    const val docs              = "io.github.javaeden.orchid:OrchidDocs:$version"
    const val pluginDocs        = "io.github.javaeden.orchid:OrchidPluginDocs:$version"
    const val kotlinDoc         = "io.github.javaeden.orchid:OrchidKotlindoc:$version"
    const val search            = "io.github.javaeden.orchid:OrchidSearch:$version"
    const val writerBlocks      = "io.github.javaeden.orchid:OrchidWritersBlocks:$version"
    const val syntaxHighlighter = "io.github.javaeden.orchid:OrchidSyntaxHighlighter:$version"
    const val editorialTheme    = "io.github.javaeden.orchid:OrchidEditorial:$version"
    const val diagrams          = "io.github.javaeden.orchid:OrchidDiagrams:$version"
    const val github            = "io.github.javaeden.orchid:OrchidGithub:$version"
    const val changelog         = "io.github.javaeden.orchid:OrchidChangelog:$version"
}