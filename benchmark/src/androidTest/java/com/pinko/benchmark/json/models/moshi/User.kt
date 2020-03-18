package com.pinko.benchmark.json.models.moshi


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * From: https://github.com/mootazltaief/android-json-benchmark
 */
@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "company")
    val company: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "gender")
    val gender: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "phone")
    val phone: String
)