package com.pinko.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.pinko.dependencies.Plugins

/**
 * Custom Gradle plugin for Android application.
 *
 * Applies plugins, sets the Android configuration and adds the common dependencies.
 */
open class AndroidApplicationGradlePlugin : Plugin<Project> {

  private lateinit var project: Project

  override fun apply(project: Project) {
    this.project = project

    apply(Plugins.AndroidApplication.plugin)
    apply(Plugins.AndroidKotlin.plugin)
    apply(Plugins.KotlinKapt.plugin)

    // Spek2 requires as JUnit 5 doesn't support android modules out of the box.
    apply(Plugins.Junit5Android.plugin)

    project.configureAndroid()
    project.configureDependencies()
  }

  private fun apply(plugin: String) {
    project.pluginManager.apply(plugin)
  }
}


