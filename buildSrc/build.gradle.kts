repositories {
    jcenter()
    google()

    maven("http://dl.bintray.com/kotlin/kotlin-eap")
}

plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}