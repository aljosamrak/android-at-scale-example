package com.pinko.benchmark.json.implementations

import android.content.Context
import com.pinko.benchmark.json.Utils
import com.pinko.benchmark.json.models.kotlin.Photos
import com.pinko.benchmark.json.models.kotlin.User
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

/**
 * From: https://github.com/mootazltaief/android-json-benchmark
 */
@UnstableDefault
class KotlinParser(context: Context) {

    private val sample1 =
        Utils.loadJSONFromAsset(context, "sample1.json")
    private val sample2 =
        Utils.loadJSONFromAsset(context, "sample2.json")
    private val sample3 =
        Utils.loadJSONFromAsset(context, "sample3.json")

    fun parseSample1(): List<User> {
        return Json.parse(User.serializer().list, sample1)
    }

    fun parseSample2(): List<User> {
        return Json.parse(User.serializer().list, sample2)
    }

    fun parseSample3(): Photos {
        return Json.parse(Photos.serializer(), sample3)
    }
}