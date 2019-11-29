buildscript {
    repositories {
        google()
        jcenter()
        maven(Repositories.kotlinEap)
    }
    dependencies {
        classpath (BuildPlugins.androidGradlePlugin)
        classpath (BuildPlugins.kotlinGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven(Repositories.kotlinEap)
    }
}

tasks.register("clean").configure {
    delete("build")
}