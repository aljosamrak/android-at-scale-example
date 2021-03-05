package com.pinko.location

import android.content.Context
import android.util.Log
import com.google.android.gms.location.LocationAvailability
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import mu.KotlinLogging
import java.io.File

class LocationSaverCallback(context: Context) : LocationCallback() {

  fun getFile() = ""
  
  private val logger = KotlinLogging.logger {}

  var filename = "export.csv"

  var path = context.getExternalFilesDir(null)   //get file directory for this package
  //(Android/data/.../files | ... is your app package)

  //create fileOut object
  var fileOut: File

  init {
    var i = 0
    do {
      fileOut = File(path, "export-$i.csv")
      ++i
    } while(fileOut.exists())

    fileOut.createNewFile()
  }


  override fun onLocationAvailability(p0: LocationAvailability) {
    super.onLocationAvailability(p0)
  }

  override fun onLocationResult(locationResult: LocationResult) {
    super.onLocationResult(locationResult)

    logger.debug("Location: Got Location - $locationResult")
    locationResult.locations.forEach { location ->
      logger.debug("Location: ${location.latitude} -- ${location.longitude}")
      Log.d("Location", "Location: ${location.latitude} -- ${location.longitude}")


      fileOut.appendText(location.latitude.toString())
      fileOut.appendText(",")
      fileOut.appendText(location.longitude.toString())
      fileOut.appendText("\n")

//        File("application.log").writeText("Hello, Logging")
    }
  }
}
