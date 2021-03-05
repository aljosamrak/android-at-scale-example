plugins {
  base        //TODO - not working, move to the plugin if possible
  id(BuildPlugins.customAndroidApplication)
}

android {
  defaultConfig {
    applicationId = "com.pinko.mapexplorer"
    versionCode = 1
    versionName = "0.1.0"
//    versionCode = Apps.versionCode
//    versionName = Apps.versionName

//        // Inject the Maps API key into the manifest
//        manifestPlaceholders = [ mapsApiKey : properties.getProperty("MAPS_API_KEY", "") ]
  }
}

dependencies {
  // Util lib to handle permission request
  implementation(Helper.permission)

  // Location Google Play Services lib
  implementation(GooglePlayServices.location)

  // Google Maps util lib
  implementation(Google.maps)
}