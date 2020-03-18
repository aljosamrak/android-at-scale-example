package com.pinko.benchmark.json.implementations

import android.content.Context
import com.pinko.benchmark.json.Utils
import com.pinko.benchmark.json.models.moshi.Photos
import com.pinko.benchmark.json.models.moshi.User
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types.newParameterizedType
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

/**
 * From: https://github.com/mootazltaief/android-json-benchmark
 */
class MoshiParser(context: Context) {

    private val sample1 =
        Utils.loadJSONFromAsset(context, "sample1.json")
    private val sample2 =
        Utils.loadJSONFromAsset(context, "sample2.json")
    private val sample3 =
        Utils.loadJSONFromAsset(context, "sample3.json")

    val moshi = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private var moshiUserListType = newParameterizedType(List::class.java, User::class.java)

    private val moshiUserAdapter: JsonAdapter<List<User>> = moshi.adapter(moshiUserListType)

    private val moshiPhotosAdapter: JsonAdapter<Photos> = moshi.adapter(
        Photos::class.java
    )


    fun parseSample1(): List<User>? {
        return moshiUserAdapter.fromJson(sample1)
    }

    fun parseSample2(): List<User>? {
        return moshiUserAdapter.fromJson(sample2)
    }

    fun parseSample3(): Photos? {
        return moshiPhotosAdapter.fromJson(sample3)
    }
}