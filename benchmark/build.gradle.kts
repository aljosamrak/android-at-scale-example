plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(plugin.Plugins.Benchmark.plugin)
    kotlin(plugin.Plugins.KotlinSerialization.plugin)
    kotlin(plugin.Plugins.Kapt.plugin)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion(AndroidSdk.buildTools)

    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = TestInstrumentationRunner.benchmark
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildTypes {
        getByName("debug") {
            // Since debuggable can't be modified by gradle for library modules,
            // it must be done in a manifest - see src/androidTest/AndroidManifest.xml
            minifyEnabled(true)
            proguardFiles("proguard-android-optimize.txt", "benchmark-proguard-rules.pro")
            testProguardFiles("proguard-android-optimize.txt", "benchmark-proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(Libraries.kotlinStdLib)

    androidTestImplementation(TestLibraries.androidxBenchmark)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.androidxJunit)
    androidTestImplementation(TestLibraries.junit4)

    androidTestImplementation(Json.gson)
    androidTestImplementation(Json.kotlinSerialization)
    androidTestImplementation(Json.jackson)
    androidTestImplementation(Json.moshi)
    kapt(Json.moshiCodegen)
}