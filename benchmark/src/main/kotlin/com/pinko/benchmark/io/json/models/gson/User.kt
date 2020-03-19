package com.pinko.benchmark.io.json.models.gson


import com.google.gson.annotations.SerializedName

/**
 * From: https://github.com/mootazltaief/android-json-benchmark
 */
data class User(
    @SerializedName("company")
    val company: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String
)