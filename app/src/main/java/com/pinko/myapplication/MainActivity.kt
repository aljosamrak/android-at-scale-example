package com.pinko.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
//import com.pinko.library.debug.DebugActivity
//import mu.KLogging


//import com.krishna.debug_tools.activity.ActivityDebugTools
//class MainActivity : DebugActivity() {
class MainActivity : AppCompatActivity() {

//    companion object : KLogging()


    override fun onCreate(savedInstanceState: Bundle?) {
//        logger.entry()

//        val contex: Context = applicationContext
//        val intent = Intent(contex, ActivityDebugTools::class.java)
//        startActivity(intent)

        setContent {
            MaterialTheme {
                Greeting("Android")
            }
        }
        super.onCreate(savedInstanceState)
    }
}

//TODO add lint checks

//TODO set log levels per debug, qa, release

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
