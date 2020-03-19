package com.pinko.benchmark.io.file

import okio.Okio
import java.io.InputStream


/**
 * Created by Aljoša Mrak on 19.3.2020.
 */
class OkioTextFileRead {

    fun byLineConcatReadFile(inputStream: InputStream): String {
        var text = ""
        Okio.buffer(Okio.source(inputStream)).use { source ->
            var line: String?
            while (source.readUtf8Line().also { line = it } != null) {
                if (text.isNotEmpty()) {
                    text += "\n"
                }
                text += line
            }
        }
        return text
    }

    fun byLineStringBuilderReadFile(inputStream: InputStream): String {
        val stringBuilder = StringBuilder()
        Okio.buffer(Okio.source(inputStream)).use { source ->
            var line: String?
            while (source.readUtf8Line().also { line = it } != null) {
                if (stringBuilder.isNotEmpty()) {
                    stringBuilder.append("\n")
                }
                stringBuilder.append(line)
            }
        }
        return stringBuilder.toString()
    }

    fun byLineStringBufferReadFile(inputStream: InputStream): String {
        val stringBuffer = StringBuffer()
        Okio.buffer(Okio.source(inputStream)).use { source ->
            var line: String?
            while (source.readUtf8Line().also { line = it } != null) {
                if (stringBuffer.isNotEmpty()) {
                    stringBuffer.append("\n")
                }
                stringBuffer.append(line)
            }
        }
        return stringBuffer.toString()
    }
}