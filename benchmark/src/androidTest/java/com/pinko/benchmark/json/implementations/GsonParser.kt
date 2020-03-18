package com.pinko.benchmark.json.implementations

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pinko.benchmark.json.Utils
import com.pinko.benchmark.json.models.gson.Photos
import com.pinko.benchmark.json.models.gson.User

/**
 * From: https://github.com/mootazltaief/android-json-benchmark
 */
class GsonParser(context: Context) {

    private var gson = Gson()

    private val sample1 =
        Utils.loadJSONFromAsset(context, "sample1.json")
    private val sample2 =
        Utils.loadJSONFromAsset(context, "sample2.json")
    private val sample3 =
        Utils.loadJSONFromAsset(context, "sample3.json")

    private val userTypeToken = object : TypeToken<List<User>>() {}.type

    fun parseSample1(): List<User> {
        return gson.fromJson(sample1, userTypeToken)
    }

    fun parseSample2(): List<User> {
        return gson.fromJson(sample2, userTypeToken)
    }

    fun parseSample3(): Photos {
        return gson.fromJson(sample3, Photos::class.java)
    }
}