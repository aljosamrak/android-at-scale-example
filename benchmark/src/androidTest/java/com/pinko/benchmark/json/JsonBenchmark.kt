package com.pinko.benchmark.json

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.pinko.benchmark.json.implementations.GsonParser
import com.pinko.benchmark.json.implementations.JacksonParser
import com.pinko.benchmark.json.implementations.KotlinParser
import com.pinko.benchmark.json.implementations.MoshiParser
import kotlinx.serialization.UnstableDefault
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * From: https://github.com/mootazltaief/android-json-benchmark
 */
@UnstableDefault
@RunWith(AndroidJUnit4::class)
class JsonBenchmark {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    private val appContext = InstrumentationRegistry.getInstrumentation().targetContext
    private val gsonParser = GsonParser(appContext)
    private val moshiParser = MoshiParser(appContext)
    private val kotlinParser = KotlinParser(appContext)
    private val jacksonParser = JacksonParser(appContext)

    @Test
    fun benchmarkGsonWithSample1() = benchmarkRule.measureRepeated {
        gsonParser.parseSample1()
    }

    @Test
    fun benchmarkGsonWithSample2() {
        benchmarkRule.measureRepeated {
            gsonParser.parseSample2()
        }
    }

    @Test
    fun benchmarkGsonWithSample3() {
        benchmarkRule.measureRepeated {
            gsonParser.parseSample3()
        }
    }

    @Test
    fun benchmarkMoshiWithSample1() {
        benchmarkRule.measureRepeated {
            moshiParser.parseSample1()
        }
    }

    @Test
    fun benchmarkMoshiWithSample2() {
        benchmarkRule.measureRepeated {
            moshiParser.parseSample2()
        }
    }

    @Test
    fun benchmarkMoshiWithSample3() {
        benchmarkRule.measureRepeated {
            moshiParser.parseSample3()
        }
    }

    @Test
    fun benchmarkKotlinWithSample1() {
        benchmarkRule.measureRepeated {
            kotlinParser.parseSample1()
        }
    }

    @Test
    fun benchmarkKotlinWithSample2() {
        benchmarkRule.measureRepeated {
            kotlinParser.parseSample2()
        }
    }

    @Test
    fun benchmarkKotlinWithSample3() {
        benchmarkRule.measureRepeated {
            kotlinParser.parseSample3()
        }
    }

    @Test
    fun benchmarkJacksonWithSample1() {
        benchmarkRule.measureRepeated {
            jacksonParser.parseSample1()
        }
    }

    @Test
    fun benchmarkJacksonWithSample2() {
        benchmarkRule.measureRepeated {
            jacksonParser.parseSample2()
        }
    }

    @Test
    fun benchmarkJacksonWithSample3() {
        benchmarkRule.measureRepeated {
            jacksonParser.parseSample3()
        }
    }
}