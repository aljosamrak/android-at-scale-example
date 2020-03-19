package com.pinko.benchmark.io.file

import okio.Okio
import org.apache.commons.io.IOUtils
import org.apache.commons.io.LineIterator
import java.io.InputStream


/**
 * Created by Aljoša Mrak on 19.3.2020.
 */
class OkioTextFileRead {

    fun concatReadFile1(inputStream: InputStream): String {
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
    
    fun concatReadFile2(inputStream: InputStream): String {
        val it = IOUtils.lineIterator(inputStream, "UTF-8")
        var text = ""
        try {
            while (it.hasNext()) {
                // do something with line
                if (text.isNotEmpty()) {
                    text += "\n"
                }
                text += it.nextLine()
            }
        } finally {
            LineIterator.closeQuietly(it)
        }
        return text
    }

    fun stringBuilderReadFile1(inputStream: InputStream): String {
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

    fun stringBuilderReadFile2(inputStream: InputStream): String {
        val it = IOUtils.lineIterator(inputStream, "UTF-8")
        val stringBuilder = StringBuilder()
        try {
            while (it.hasNext()) {
                // do something with line
                if (stringBuilder.isNotEmpty()) {
                    stringBuilder.append("\n")
                }
                stringBuilder.append(it.nextLine())
            }
        } finally {
            LineIterator.closeQuietly(it)
        }
        return stringBuilder.toString()
    }

    fun stringBufferReadFile1(inputStream: InputStream): String {
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

    fun stringBufferReadFile2(inputStream: InputStream): String {
        val it = IOUtils.lineIterator(inputStream, "UTF-8")
        val stringBuffer = StringBuffer()
        try {
            while (it.hasNext()) {
                // do something with line
                if (stringBuffer.isNotEmpty()) {
                    stringBuffer.append("\n")
                }
                stringBuffer.append(it.nextLine())
            }
        } finally {
            LineIterator.closeQuietly(it)
        }
        return stringBuffer.toString()
    }
}