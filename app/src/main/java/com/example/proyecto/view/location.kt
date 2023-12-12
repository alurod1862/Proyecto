package com.example.proyecto.view
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices


@SuppressLint("MissingPermission")
fun obtenerUbicacionActual(context: Context, onLocationResult: (Location?) -> Unit) {
    val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    // Configurar la solicitud de ubicación
    val locationRequest = LocationRequest.create()
    locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    locationRequest.numUpdates = 1

    // Obtener la ubicación actual
    try {
        val locationTask = fusedLocationClient.lastLocation
        locationTask.addOnSuccessListener { location: Location? ->
            println("Ubicación actual: $location")
            onLocationResult(location)
        }
    } catch (e: Exception) {
        // Manejar excepciones, por ejemplo, si los permisos no están concedidos
        onLocationResult(null)
    }
}





