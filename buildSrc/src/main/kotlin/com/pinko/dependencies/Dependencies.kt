import TestLibraries.Versions.spekVersion

object Kotlin {
    const val kotlinVersion = "1.4.21"

    const val std           = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    const val reflect       = "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
}

object BuildPlugins {

    object Versions {
//        const val buildToolsVersion = "7.0.0-alpha08"
        const val buildToolsVersion = "4.0.0"
        const val sonarcube = "2.8"
        const val gPlayPublishingVersion = "2.6.1"
    }


    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"

    const val customAndroidApplication = "com.pinko.plugin.android.aplication"
}
//    const val sonarqube = "org.sonarqube"
//    const val gPlayPublishing = "com.github.triplet.play"
//    const val speck = "de.mannodermaus.android-junit5"
//}

///home/aljosa/.gradle/caches/transforms-2/files-2.1/6ffe9d05461be5405eac199da63ac711/jetified-kotlin-stdlib-jdk8-1.3.61.jar (version 1.3)
///home/aljosa/.gradle/caches/transforms-2/files-2.1/ef41e762fdad1b43eeb534eb31f3e62a/jetified-kotlin-reflect-1.2.71.jar (version 1.2)
///home/aljosa/.gradle/caches/transforms-2/files-2.1/7fe7071c8ec4a58524c908f4920034a9/jetified-kotlin-stdlib-jdk7-1.3.61.jar (version 1.3)
///home/aljosa/.gradle/caches/transforms-2/files-2.1/c435ef88095f14072f21e03045ec4303/jetified-kotlin-stdlib-1.3.61.jar (version 1.3)
///home/aljosa/.gradle/caches/transforms-2/files-2.1/94de6a71cc5bf52d2f1b9a4bde9c16bc/jetified-kotlin-stdlib-common-1.3.61.jar (version 1.3)


object AndroidSdk {
    const val buildTools = "29.0.2"
    const val min = 21
    const val compile = 30
    const val target = compile
}


object Libraries {
    private object Versions {
        const val jetpack = "1.3.0-alpha01"
        const val constraintLayout = "2.0.0-beta4"
        const val ktx = "1.4.0-alpha01"
        const val compose = "0.1.0-dev10"
        const val material = "1.3.0"
        const val lifecycle = "2.3.0"
        const val navigation = "2.3.3"
        const val googleMaps = "2.2.0"
    }

    const val appCompat             = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout      = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore               = "androidx.core:core-ktx:${Versions.ktx}"

    const val androidMaterial       = "com.google.android.material:material:${Versions.material}"
    const val androidxUiFramework   = "androidx.ui:ui-framework:${Versions.compose}"
    const val androidxUiLayout      = "androidx.ui:ui-layout:${Versions.compose}"
    const val androidxUiMaterial    = "androidx.ui:ui-material:${Versions.compose}"
    const val androidxUiTooling     = "androidx.ui:ui-tooling:${Versions.compose}"
    const val androidxLivecycleLiveData      = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val androidxLifecycleViewModel      = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val androidxNavigationFragment    = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val androidxNavigationUi    = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    const val googleMapsUtils    = "com.google.maps.android:maps-utils-ktx:${Versions.googleMaps}"

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

object GooglePlayServices {
    const val version    = "18.0.0"

    const val location        = "com.google.android.gms:play-services-location:$version"
}

object Google {
    private object Versions {
        const val maps    = "2.4.0"
    }

    const val maps        = "com.google.maps.android:maps-utils-ktx:${Versions.maps}"
}

object Helper {
    private object Versions {
        const val dexter    = "6.2.2"
    }

    const val permission        = "com.karumi:dexter:${Versions.dexter}"
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
    private const val kotlinLoggingVersion = "2.0.4"
    private const val slf4jLogbackVersion         = "2.0.0"
    private const val self4jLogbackClassicVersion = "1.3.0-alpha5"

    const val kotlinLogging         = "io.github.microutils:kotlin-logging-jvm:$kotlinLoggingVersion"
    const val slf4jLogback          = "com.github.tony19:logback-android:$slf4jLogbackVersion"
    const val slf4jLogbackClassic   = "ch.qos.logback:logback-classic:$self4jLogbackClassicVersion"
}

object TestLibraries {
    private object Versions {
        const val androidxJunit = "1.1.1"
        const val assertj = "3.19.0"
        const val benchmark = "1.0.0"
        const val espresso = "3.2.0"
        const val junit5 = "5.8.0"
        const val junitAndroid = "1.2.2"
        const val spekVersion = "2.0.15"
        const val androidTestRunner = "1.2.0"
    }

    const val instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val androidTestRunner            = "androidx.test:runner:${Versions.androidTestRunner}"
    const val espresso              = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val androidxBenchmark     = "androidx.benchmark:benchmark-junit4:${Versions.benchmark}"
    const val androidxJunit         = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val assertj               = "org.assertj:assertj-core:${Versions.assertj}"

    object JUnit5 {
        const val engine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit5}"
        const val api = "org.junit.jupiter:junit-jupiter-api:${Versions.junit5}"
        const val androidCore = "de.mannodermaus.junit5:android-test-core:${Versions.junitAndroid}"
        const val androidRunner = "de.mannodermaus.junit5:android-test-runner:${Versions.junitAndroid}"
    }

    object Spek2 {
        const val jvm               = "org.spekframework.spek2:spek-dsl-jvm:$spekVersion"
        const val runner            = "org.spekframework.spek2:spek-runner-junit5:$spekVersion"
    }
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

/**
 * https://github.com/palaima/DebugDrawer
 */
object AndroidDebugDrawer {
    const val version = "0.8.0"

    const val debugDrawer       = "io.palaima.debugdrawer:debugdrawer:$version"
    const val debugDrawerBase   = "io.palaima.debugdrawer:debugdrawer-base:$version"
    const val debugView         = "io.palaima.debugdrawer:debugdrawer-view:$version"
    const val common            = "io.palaima.debugdrawer:debugdrawer-commons:$version"         // BuildModule, DeviceModule, SettingsModule, NetworkModule
    const val actions           = "io.palaima.debugdrawer:debugdrawer-actions:$version"         // ActionsModule - ButtonAction, SwitchAction, SpinnerAction
    //        implementation "io.palaima.debugdrawer:debugdrawer-okhttp:$version" // OkHttpModule, OkHttp3Module OkHttp library required
    const val okhttp            = "io.palaima.debugdrawer:debugdrawer-okhttp3:$version"
    const val picasso           = "io.palaima.debugdrawer:debugdrawer-picasso:$version"         // PicassoModule Picasso library required
    const val glide             = "io.palaima.debugdrawer:debugdrawer-glide:$version"           // GlideModule Glide library required
    const val scalpel           = "io.palaima.debugdrawer:debugdrawer-scalpel:$version"         // ScalpelModule Scalpel library required
    const val location          = "io.palaima.debugdrawer:debugdrawer-location:$version"        //LocationModule
    const val timber            = "io.palaima.debugdrawer:debugdrawer-timber:$version"          // TimberModule Timber library required
    const val fps               = "io.palaima.debugdrawer:debugdrawer-fps:$version"             // FpsModule Takt library required
    const val logs              = "io.palaima.debugdrawer:debugdrawer-logs:$version"            // LogsModule Lynx & Chuck libraries required
    const val networkQuality    = "io.palaima.debugdrawer:debugdrawer-network-quality:$version" // NetworkQualityModule OkHttp library required
}