package com.pinko.benchmark.io.file

import android.content.Context
import android.os.Build
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.ByteBuffer
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.util.*
import java.util.stream.Collectors


class JavaTextFileRead {

    fun concatReadFile0(inputStream: InputStream): String {
        var result = ""
        BufferedReader(InputStreamReader(inputStream)).use { source ->
            var mLine = source.readLine()
            while (mLine != null) {
                if (result.isNotEmpty()) {
                    result += "\n"
                }
                result += mLine
                mLine = source.readLine()
            }
        }
        return result
    }

    fun concatReadFile1(inputStream: InputStream): String {
        BufferedReader(InputStreamReader(inputStream)).use { source ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                return source.lines().collect(Collectors.joining("\n"))
            }
        }
        return ""
    }

    fun concatReadFile2(inputStream: InputStream): String {
        return inputStream.bufferedReader().use(BufferedReader::readText)
    }

    fun concatReadFile3(inputStream: InputStream): String {
        return inputStream.bufferedReader().useLines {
            it.reduce { acc, line -> acc + "\n" + line }
        }
    }

    fun concatReadFile4(inputStream: InputStream): String {
        var result = ""
        inputStream.bufferedReader().forEachLine {
            if (result.isNotEmpty()) {
                result += "\n"
            }
            result += it
        }
        return result
    }

    fun concatReadFile5(fileName: String, context: Context): String {
        try {
            val length = context.assets.openFd(fileName).length

            val assetFd = context.assets.openFd(fileName)
            val fileChannel = assetFd.createInputStream().channel

            val buff: ByteBuffer = ByteBuffer.allocate(length.toInt())
            fileChannel.read(buff)
            buff.flip()
            val returnString: String = Charset.forName("UTF-8").decode(buff).toString()
            buff.clear()
            fileChannel.close()
            return returnString
        } catch (e: Exception) {
            return ""
        }
    }

    fun concatReadFile6(fileName: String, context: Context): String {
        val length = context.assets.openFd(fileName).length
        val buf = ByteArray(length.toInt())
        var cnt = 0
        var n: Int
        val inputStream = context.assets.open(fileName)
        while (inputStream.read(buf).also { n = it } != -1) {
            for (i in 0 until n) {
                if (buf[i] == '\n'.toByte()) cnt++
            }
        }
        inputStream.close()
        return String(buf, StandardCharsets.UTF_8)
    }

    fun concatReadFile7(inputStream: InputStream): String {
        var sc: Scanner? = null
        var result = ""
        try {
            sc = Scanner(inputStream, "UTF-8")
            while (sc.hasNextLine()) {
                if (result.isNotEmpty()) {
                    result += "\n"
                }
                result += sc.nextLine()
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException()
            }
        } finally {
            inputStream.close()
            sc?.close()
        }
        return result
    }

    fun concatReadFile8(inputStream: InputStream): String {
        var sc: Scanner? = null
        val result: String
        try {
            sc = Scanner(inputStream, "UTF-8")
            // we just need to use \\Z as delimiter
            sc.useDelimiter("\\Z")

            result = sc.next()
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException()
            }
        } finally {
            inputStream.close()
            sc?.close()
        }
        return result
    }

    fun stringBuilderReadFile1(inputStream: InputStream): String {
        val stringBuilder = StringBuilder()
        BufferedReader(InputStreamReader(inputStream)).use { source ->
            var mLine: String?
            while (source.readLine().also { mLine = it } != null) {
                if (stringBuilder.isNotEmpty()) {
                    stringBuilder.append("\n")
                }
                stringBuilder.append(mLine)
            }
        }
        return stringBuilder.toString()
    }

    fun stringBuilderReadFile3(inputStream: InputStream): String {
        val stringBuilder = StringBuilder()
        inputStream.bufferedReader().useLines {
            it.forEach { line ->
                run {
                    if (stringBuilder.isNotEmpty()) {
                        stringBuilder.append("\n")
                    }
                    stringBuilder.append(line)
                }
            }
        }
        return stringBuilder.toString()
    }

    fun stringBuilderReadFile4(inputStream: InputStream): String {
        val stringBuilder = StringBuilder()
        inputStream.bufferedReader().forEachLine {
            if (stringBuilder.isNotEmpty()) {
                stringBuilder.append("\n")
            }
            stringBuilder.append(it)
        }
        return stringBuilder.toString()
    }

    fun stringBuilderReadFile7(inputStream: InputStream): String {
        var sc: Scanner? = null
        val stringBuilder = StringBuffer()
        try {
            sc = Scanner(inputStream, "UTF-8")
            while (sc.hasNextLine()) {
                if (stringBuilder.isNotEmpty()) {
                    stringBuilder.append("\n")
                }
                stringBuilder.append(sc.nextLine())
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException()
            }
        } finally {
            inputStream.close()
            sc?.close()
        }
        return stringBuilder.toString()
    }

    fun stringBufferReadFile1(inputStream: InputStream): String {
        val stringBuffer = StringBuffer()
        BufferedReader(InputStreamReader(inputStream)).use { source ->
            var mLine: String?
            while (source.readLine().also { mLine = it } != null) {
                if (stringBuffer.isNotEmpty()) {
                    stringBuffer.append("\n")
                }
                stringBuffer.append(mLine)
            }
        }
        return stringBuffer.toString()
    }

    fun stringBufferReadFile3(inputStream: InputStream): String {
        val stringBuffer = StringBuffer()
        inputStream.bufferedReader().useLines {
            it.forEach { line ->
                run {
                    if (stringBuffer.isNotEmpty()) {
                        stringBuffer.append("\n")
                    }
                    stringBuffer.append(line)
                }
            }
        }
        return stringBuffer.toString()
    }

    fun stringBufferReadFile4(inputStream: InputStream): String {
        val stringBuffer = StringBuffer()
        inputStream.bufferedReader().forEachLine {
            if (stringBuffer.isNotEmpty()) {
                stringBuffer.append("\n")
            }
            stringBuffer.append(it)
        }
        return stringBuffer.toString()
    }

    fun stringBufferReadFile7(inputStream: InputStream): String {
        var sc: Scanner? = null
        val stringBuffer = StringBuffer()
        try {
            sc = Scanner(inputStream, "UTF-8")
            while (sc.hasNextLine()) {
                if (stringBuffer.isNotEmpty()) {
                    stringBuffer.append("\n")
                }
                stringBuffer.append(sc.nextLine())
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException()
            }
        } finally {
            inputStream.close()
            sc?.close()
        }
        return stringBuffer.toString()
    }
}