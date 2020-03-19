package com.pinko.benchmark.io.file

import org.apache.commons.io.IOUtils
import org.apache.commons.io.LineIterator
import java.io.InputStream

/**
 * Created by Aljoša Mrak on 19.3.2020.
 */
class ApacheTextFileRead {

    fun wholeReadFile(inputStream: InputStream): String? {
        return IOUtils.toString(inputStream, "UTF-8")
    }

    fun byLineConcatReadFile(inputStream: InputStream): String {
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

    fun byLineStringBuilderReadFile(inputStream: InputStream): String {
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

    fun byLineStringBufferReadFile(inputStream: InputStream): String {
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