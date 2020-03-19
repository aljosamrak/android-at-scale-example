package com.pinko.benchmark.io.json.models.kotlin

import kotlinx.serialization.Serializable

/**
 * From: https://github.com/mootazltaief/android-json-benchmark
 */
@Serializable
data class User(
    val company: String,
    val email: String,
    val gender: String,
    val id: String,
    val name: String,
    val phone: String
)