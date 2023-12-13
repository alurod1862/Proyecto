package com.example.proyecto.model

import android.annotation.SuppressLint
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import java.io.IOException
import java.util.Locale


class LoginViewModel  : ViewModel() {

    private var _user = MutableLiveData("")
    val user: LiveData<String> = _user


    private var _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private var _location = MutableLiveData("")
    val location: LiveData<String> = _location

    fun setLocation(location: String){
        _location.value = location
    }

    fun setUser(user: String) {
        _user.value = user
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun checkPassword(): Boolean {
            val password = _password.value
            if (password != null) {
                return password.length > 6
            }
        return false
    }


    fun checkEmail(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(_user.value).matches()
    }


    fun checkUser(): Boolean {
        if (checkUser() && checkUser()){return true}
        return false
    }


    @Composable
    fun LocationComponent(context: Context) {
        val currentLocation = remember { mutableStateOf<Location?>(null) }
        val cityName = remember { mutableStateOf<String?>(location.value) }
        _location.value = cityName.value.toString()
        GetCurrentLocation(context, currentLocation, cityName)
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


}