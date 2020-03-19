package com.pinko.benchmark.io.json

import android.content.Context

/**
 * From: https://github.com/mootazltaief/android-json-benchmark
 */
object Utils {

    fun loadJSONFromAsset(context: Context, fileName: String): String {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        return String(buffer)
    }

}