package com.pinko.myapplication


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import mu.KLogging

class MainActivity : AppCompatActivity() {

    companion object : KLogging()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logger.entry()

        setContent {
            MaterialTheme {
                Greeting("Android")
            }
        }
    }
}

@Composable
private fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview
@Composable
private fun DefaultPreview() {
    MaterialTheme {
        Greeting("Android")
    }
}
