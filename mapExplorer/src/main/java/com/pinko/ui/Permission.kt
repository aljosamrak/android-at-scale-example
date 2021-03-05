package com.pinko.ui

import android.Manifest
import android.content.Context
import com.example.mapexplorer.R
import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.DexterError
import com.karumi.dexter.listener.PermissionRequestErrorListener
import com.karumi.dexter.listener.multi.DialogOnAnyDeniedMultiplePermissionsListener
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun checkLocationPermission(context: Context) {
  val permissionsListener: MultiplePermissionsListener =
    DialogOnAnyDeniedMultiplePermissionsListener.Builder
      .withContext(context)
      .withTitle("Location permission")
      .withMessage("Both location permissions are needed to take pictures of your cat")
      .withButtonText(android.R.string.ok)
      .withIcon(R.mipmap.ic_launcher)
      .build()

  Dexter.withContext(context)
    .withPermissions(
      Manifest.permission.ACCESS_FINE_LOCATION,
      Manifest.permission.ACCESS_COARSE_LOCATION
    )
    .withListener(permissionsListener)
    .withErrorListener(ErrorListener())
    .check()
}

class ErrorListener : PermissionRequestErrorListener {
  override fun onError(error: DexterError?) {
    logger.error { "Dexter: There was an error:'$error'" }
  }
}