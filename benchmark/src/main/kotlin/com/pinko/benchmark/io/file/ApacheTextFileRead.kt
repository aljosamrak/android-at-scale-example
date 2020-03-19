package com.pinko.benchmark.io.file

import org.apache.commons.io.IOUtils
import java.io.InputStream

/**
 * Created by Aljoša Mrak on 19.3.2020.
 */
class ApacheTextFileRead {
    fun readStringFile1(inputStream: InputStream): String? {
        return IOUtils.toString(inputStream, "UTF-8")
    }
}