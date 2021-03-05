package com.pinko

import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.os.PersistableBundle
import android.provider.Settings
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import com.example.mapexplorer.BuildConfig
import com.example.mapexplorer.R
import com.example.mapexplorer.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.material.navigation.NavigationView
import com.pinko.MainActivity.DbConstants.LOCATION_INTERVAL
import com.pinko.HeatmapHelper.addHeatMap
import com.pinko.location.LocationSaverCallback
import com.pinko.ui.checkLocationPermission
import mu.KotlinLogging

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

  object DbConstants {
    const val LOCATION_INTERVAL: Long = 20 * 1000 // 20s
  }

  private val logger = KotlinLogging.logger {}

  private lateinit var appBarConfiguration: AppBarConfiguration
  private lateinit var binding: ActivityMainBinding

  private lateinit var fusedLocationClient: FusedLocationProviderClient

  private val locationCallback by lazy { LocationSaverCallback(applicationContext) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    printDebugInfo()

    fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

    updateValuesFromBundle(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

//        setSupportActionBar(binding.appBarMain.toolbar)

//        binding.appBarMain.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    val drawerLayout: DrawerLayout = binding.drawerLayout
    val navView: NavigationView = binding.navView
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    appBarConfiguration = AppBarConfiguration(
      setOf(
        R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
      ), drawerLayout
    )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)

    setUpMapIfNeeded()
  }

  private fun permissionGranted(vararg permissions: String): Boolean {
    return permissions.all { permission ->
      ActivityCompat.checkSelfPermission(
        this,
        permission
      ) == PERMISSION_GRANTED
    }
  }

  override fun onResume() {
    super.onResume()
//        if (requestingLocationUpdates) {
//            startLocationUpdates()
//        }

    checkLocationPermission(applicationContext)

    val provided = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
      // This is a new method provided in API 28
      val lm = getSystemService(LOCATION_SERVICE) as LocationManager
      lm.isLocationEnabled
    } else {
      // This was deprecated in API 28
      val mode: Int = Settings.Secure.getInt(
        getContentResolver(), Settings.Secure.LOCATION_MODE,
        Settings.Secure.LOCATION_MODE_OFF
      )
      mode != Settings.Secure.LOCATION_MODE_OFF
    }

    logger.info("Location provided: '$provided'")
    //TODO open settiungs
    // TODO on location enabled start

    val locationRequest = LocationRequest.create()
    locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    locationRequest.interval = LOCATION_INTERVAL//TODO dynamic???

    fusedLocationClient.requestLocationUpdates(
      locationRequest,
      locationCallback,
      Looper.getMainLooper()
    )
  }


  private fun updateValuesFromBundle(savedInstanceState: Bundle?) {
    savedInstanceState ?: return

    // Update the value of requestingLocationUpdates from the Bundle.
//    if (savedInstanceState.keySet().contains(REQUESTING_LOCATION_UPDATES_KEY)) {
//        requestingLocationUpdates = savedInstanceState.getBoolean(
//            REQUESTING_LOCATION_UPDATES_KEY
//        )
//    }

    // ...

    // Update UI to match restored state
//    updateUI()
  }

  override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
//        outState?.putBoolean(REQUESTING_LOCATION_UPDATES_KEY, requestingLocationUpdates)
    super.onSaveInstanceState(outState, outPersistentState)
  }

  override fun onStop() {
    super.onStop()
//    stopLocationUpdates()
  }

  private fun stopLocationUpdates() {
    fusedLocationClient.removeLocationUpdates(locationCallback)
  }

  /**
   * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
   * installed) and the map has not already been instantiated.
   *
   *
   * If it isn't installed [SupportMapFragment] (and
   * [MapView][com.google.android.gms.maps.MapView]) will show a prompt for the user to
   * install/update the Google Play services APK on their device.
   *
   *
   * A user can return to this FragmentActivity after following the prompt and correctly
   * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
   * have been completely destroyed during this process (it is likely that it would only be
   * stopped or paused), [.onCreate] may not be called again so we should call this
   * method in [.onResume] to guarantee that it will be called.
   */

  private fun setUpMapIfNeeded() {
    // Try to obtain the map from the SupportMapFragment.
    (supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?)?.getMapAsync(this)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.main, menu)
    return true
  }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }

  override fun onMapReady(googleMap: GoogleMap?) {
    // Add a marker in Sydney, Australia,
    // and move the map's camera to the same location.
    // Add a marker in Sydney, Australia,
    // and move the map's camera to the same location.
//        val sydney = LatLng(-33.852, 151.211)
//        googleMap.addMarker(
//            MarkerOptions()
//                .position(sydney)
//                .title("Marker in Sydney")
//        )
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))// Check if we were successful in obtaining the map.
//        if (mMap != null) {
//                 Position the camera
//            }


    addHeatMap(applicationContext, googleMap)
  }


  private fun printDebugInfo() {
    logger.info(
      "BUILD_INFO\n" +
              "ApplicationId:\t${BuildConfig.APPLICATION_ID}\n" +
              "Build type:\t${BuildConfig.BUILD_TYPE}"
    )
//    logger.debug("BUILD_INFO") { BuildConfig.BUILD_TIME }
//    logger.debug("BUILD_INFO") { getString(R.string.build_time) }
  }
}