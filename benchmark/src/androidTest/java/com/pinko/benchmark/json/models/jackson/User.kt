package com.pinko.benchmark.json.models.jackson


import com.fasterxml.jackson.annotation.JsonProperty

/**
 * From: https://github.com/mootazltaief/android-json-benchmark
 */
data class User(
    @JsonProperty("company")
    val company: String,
    @JsonProperty("email")
    val email: String,
    @JsonProperty("gender")
    val gender: String,
    @JsonProperty("id")
    val id: String,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("phone")
    val phone: String
)