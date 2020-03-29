plugins {
    id("java-library")
    kotlin("jvm")
    jacoco
}

dependencies {
    implementation(Libraries.kotlinStdLib)
    testImplementation (TestLibraries.junit4)
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