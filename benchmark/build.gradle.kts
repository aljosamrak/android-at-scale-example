plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(Plugins.Benchmark.plugin)
    kotlin(Plugins.KotlinSerialization.plugin)
    kotlin(Plugins.Kapt.plugin)
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

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        getByName("debug") {
            // Since debuggable can't be modified by gradle for library modules,
            // it must be done in a manifest - see src/androidTest/AndroidManifest.xml
            minifyEnabled(true)
            proguardFiles("proguard-android-optimize.txt", "benchmark-proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(Libraries.kotlinStdLib)

    // file
    implementation(IoLibrary.apache)
    implementation(IoLibrary.guava)
    implementation(IoLibrary.okio)

    // json
    implementation(JsonLibrary.gson)
    implementation(JsonLibrary.kotlinSerialization)
    implementation(JsonLibrary.jackson)
    implementation(JsonLibrary.moshi)
    kapt(JsonLibrary.moshiCodegen)

    androidTestImplementation(TestLibraries.androidxBenchmark)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.androidxJunit)
    androidTestImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.assertj)
}
