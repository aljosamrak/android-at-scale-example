package com.pinko.benchmark.file

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.pinko.benchmark.io.file.ApacheTextFileRead
import com.pinko.benchmark.io.file.JavaTextFileRead
import com.pinko.benchmark.io.file.OkioTextFileRead
import kotlinx.serialization.UnstableDefault
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * From: https://github.com/mootazltaief/android-json-benchmark
 */
@UnstableDefault
@RunWith(AndroidJUnit4::class)
class FileBenchmark {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    private val appContext = InstrumentationRegistry.getInstrumentation().targetContext
    private val javaTextFileRead = JavaTextFileRead()
    private val okioTextFileRead = OkioTextFileRead()
    private val apacheTextFileRead = ApacheTextFileRead()

    private val file1 = "sample1.json"
    private val file1Content = appContext.assets.open(file1).bufferedReader().use{ it.readText() }

    @Test
    fun javaConcatReadFile0() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.concatReadFile0(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaConcatReadFile1() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.concatReadFile1(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaConcatReadFile2() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.concatReadFile2(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaConcatReadFile3() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.concatReadFile3(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaConcatReadFile4() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.concatReadFile4(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaConcatReadFile5() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.concatReadFile5(file1, appContext)).isEqualTo(file1Content)
    }

    @Test
    fun javaConcatReadFile6() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.concatReadFile6(file1, appContext)).isEqualTo(file1Content)
    }

    @Test
    fun javaConcatReadFile7() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.concatReadFile7(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaConcatReadFile8() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.concatReadFile8(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaStringBuilderReadFile1() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.stringBuilderReadFile1(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaStringBuilderReadFile3() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.stringBuilderReadFile3(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaStringBuilderReadFile4() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.stringBuilderReadFile4(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaStringBuilderReadFile7() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.stringBuilderReadFile7(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaStringBufferReadFile1() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.stringBufferReadFile1(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaStringBufferReadFile3() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.stringBufferReadFile3(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaStringBufferReadFile4() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.stringBufferReadFile4(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaStringBufferReadFile7() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.stringBufferReadFile7(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun okioConcatReadFile1() = benchmarkRule.measureRepeated {
        assertThat(okioTextFileRead.concatReadFile1(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun okioConcatReadFile2() = benchmarkRule.measureRepeated {
        assertThat(okioTextFileRead.concatReadFile2(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun okioStringBufferReadFile1() = benchmarkRule.measureRepeated {
        assertThat(okioTextFileRead.stringBufferReadFile1(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun okioStringBufferReadFile2() = benchmarkRule.measureRepeated {
        assertThat(okioTextFileRead.stringBufferReadFile2(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun okioStringBuilderReadFile1() = benchmarkRule.measureRepeated {
        assertThat(okioTextFileRead.stringBuilderReadFile1(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun okioStringBuilderReadFile2() = benchmarkRule.measureRepeated {
        assertThat(okioTextFileRead.stringBuilderReadFile2(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun apacheReadFile1() = benchmarkRule.measureRepeated {
        assertThat(apacheTextFileRead.readStringFile1(appContext.assets.open(file1))).isEqualTo(file1Content)
    }
}