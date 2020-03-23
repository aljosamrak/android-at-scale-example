plugins {
    id("java-library")
    kotlin("jvm")
}

dependencies {
    implementation(Libraries.kotlinStdLib)
}

configurations {
    implementation {
        resolutionStrategy.failOnVersionConflict()
    }
}

sourceSets {
    getByName("main").java.srcDirs("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}


// setup the test task
tasks.withType<Test> {
    testLogging.showExceptions = true
}