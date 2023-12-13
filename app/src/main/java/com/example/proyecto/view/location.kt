package com.example.proyecto.view


import android.annotation.SuppressLint
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.google.android.gms.maps.model.LatLng
import java.io.IOException
import java.util.Locale


@Composable
fun LocationComponent(context: Context) {
    val currentLocation = remember { mutableStateOf<Location?>(null) }
    val cityName = remember { mutableStateOf<String?>(null) }
        GetCurrentLocation(context, currentLocation, cityName)
        cityName.value?.let {
            Text(text = "Ciudad: $it")
        }
}

@SuppressLint("MissingPermission")
@Composable
fun GetCurrentLocation(context: Context, currentLocation: MutableState<Location?>, cityName: MutableState<String?>) {
    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            Log.d("Location", "Latitud: ${location.latitude}, Longitud: ${location.longitude}")
            currentLocation.value = location

            // Traducir latitud y longitud en el nombre de la ciudad
            translateLocationToCity(context, LatLng(location.latitude, location.longitude), cityName)
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        }

        override fun onProviderEnabled(provider: String) {
        }

        override fun onProviderDisabled(provider: String) {
        }
    }

    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, locationListener)
}

fun translateLocationToCity(context: Context, latLng: LatLng, cityName: MutableState<String?>) {
    val geocoder = Geocoder(context, Locale.getDefault())
    try {
        val addresses: List<Address> = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)!!
        if (addresses.isNotEmpty()) {
            val city = addresses[0].locality
            Log.d("Location", "Ciudad: $city")
            cityName.value = city
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}