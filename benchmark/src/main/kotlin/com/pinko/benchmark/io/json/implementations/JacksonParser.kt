package com.pinko.benchmark.io.json.implementations

import android.content.Context
import com.fasterxml.jackson.databind.ObjectMapper
import com.pinko.benchmark.io.json.Utils
import com.pinko.benchmark.io.json.models.jackson.Photos
import com.pinko.benchmark.io.json.models.jackson.User

/**
 * From: https://github.com/mootazltaief/android-json-benchmark
 */
class JacksonParser(context: Context) {

    private val sample1 = Utils.loadJSONFromAsset(context, "sample1.json")
    private val sample2 = Utils.loadJSONFromAsset(context, "sample2.json")
    private val sample3 = Utils.loadJSONFromAsset(context, "sample3.json")


    private val jackson = ObjectMapper()

    private var userCollectionType =
        jackson.typeFactory.constructCollectionType(List::class.java, User::class.java)

    fun parseSample1(): List<User> {
        return jackson.readValue(sample1, userCollectionType)
    }

    fun parseSample2(): List<User> {
        return jackson.readValue(sample2, userCollectionType)
    }

    fun parseSample3(): Photos {
        return jackson.readValue(sample3, Photos::class.java)
    }

}