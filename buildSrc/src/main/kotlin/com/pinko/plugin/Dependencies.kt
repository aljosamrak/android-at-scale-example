package com.pinko.plugin

import Kotlin
import Logging
import TestLibraries
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler

/** Sets dependencies to teh project */

internal fun Project.configureDependencies() = dependencies.apply {

  // Kotlin
  implementation(Kotlin.std)

  // Kotlin logging facade
  implementation(Logging.kotlinLogging)

  // SLF4J implementation
  implementation(Logging.slf4jLogback)

  // Test contract test writing framework - Spek2
  testImplementation(TestLibraries.Spek2.jvm)
  testImplementation(TestLibraries.Spek2.runner)

  // Spek2 requires kotlin-reflect, omit when already in classpath
  testImplementation(Kotlin.reflect)

  // Testing assert framework
  testImplementation(TestLibraries.assertj)

  // JUnit 5
  testRuntimeOnly(TestLibraries.JUnit5.engine)
  testImplementation(TestLibraries.JUnit5.api)

  // Jupiter API & Test Runner
  androidTestImplementation(TestLibraries.androidTestRunner)
  androidTestImplementation(TestLibraries.JUnit5.androidCore)
  androidTestRuntimeOnly(TestLibraries.JUnit5.androidRunner)
}

internal fun DependencyHandler.implementation(dependencyNotation: Any) {
  add("implementation", dependencyNotation)
}

internal fun DependencyHandler.testImplementation(dependencyNotation: Any) {
  add("testImplementation", dependencyNotation)
}

internal fun DependencyHandler.testRuntimeOnly(dependencyNotation: Any) {
  add("testRuntimeOnly", dependencyNotation)
}

internal fun DependencyHandler.androidTestImplementation(dependencyNotation: Any) {
  add("androidTestImplementation", dependencyNotation)
}

internal fun DependencyHandler.androidTestRuntimeOnly(dependencyNotation: Any) {
  add("androidTestRuntimeOnly", dependencyNotation)
}