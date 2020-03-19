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
    fun javaByLineConcatBufferedReaderReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.byLineConcatBufferedReaderReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaCollectionsConcatBufferedReaderReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.collectionsConcatBufferedReaderReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaUseReadTextConcatBufferedReaderReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.useReadTextConcatBufferedReaderReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaUseLinesConcatBufferedReaderReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.useLinesConcatBufferedReaderReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaForEachLineConcatBufferedReaderReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.forEachLineConcatBufferedReaderReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaByteBufferFileChannelReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.byteBufferFileChannelReadFile(file1, appContext)).isEqualTo(file1Content)
    }

    @Test
    fun javaByteArrayBufferedReaderReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.byteArrayBufferedReaderReadFile(file1, appContext)).isEqualTo(file1Content)
    }

    @Test
    fun javaByLineScannerReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.byLineScannerReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaWholeScannerReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.wholeScannerReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaByLineStringBuilderBufferedReaderReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.byLineStringBuilderBufferedReaderReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaUsesLineStringBuilderBufferedReaderReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.usesLineStringBuilderBufferedReaderReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaForEachLineStringBuilderBufferedReaderReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.forEachLineStringBuilderBufferedReaderReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaByLineStringBuilderScannerReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.byLineStringBuilderScannerReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaByLineStringBufferBufferedReaderReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.byLineStringBufferBufferedReaderReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaUseLinesStringBufferBufferedReaderReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.useLinesStringBufferBufferedReaderReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaForEachLineStringBufferBufferedReaderReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.forEachLineStringBufferBufferedReaderReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun javaByLineStringBufferScannerReadFile() = benchmarkRule.measureRepeated {
        assertThat(javaTextFileRead.byLineStringBufferScannerReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun okioByLineConcatReadFile() = benchmarkRule.measureRepeated {
        assertThat(okioTextFileRead.byLineConcatReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun okioByLineStringBufferReadFile() = benchmarkRule.measureRepeated {
        assertThat(okioTextFileRead.byLineStringBufferReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun okioByLineStringBuilderReadFile() = benchmarkRule.measureRepeated {
        assertThat(okioTextFileRead.byLineStringBuilderReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun apacheWholeReadFile() = benchmarkRule.measureRepeated {
        assertThat(apacheTextFileRead.wholeReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun apacheByLineConcatReadFile() = benchmarkRule.measureRepeated {
        assertThat(apacheTextFileRead.byLineConcatReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun apacheByLineStringBuilderReadFile() = benchmarkRule.measureRepeated {
        assertThat(apacheTextFileRead.byLineStringBuilderReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }

    @Test
    fun apacheByLineStringBufferReadFile() = benchmarkRule.measureRepeated {
        assertThat(apacheTextFileRead.byLineStringBufferReadFile(appContext.assets.open(file1))).isEqualTo(file1Content)
    }
}