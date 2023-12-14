package com.example.proyecto


import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto.model.LoginViewModel
import com.example.proyecto.ui.theme.ProyectoTheme
import com.example.proyecto.view.calcularPropina
import com.example.proyecto.view.conversorMoneda
import com.example.proyecto.view.historialViajes
import com.example.proyecto.view.informacionDestino
import com.example.proyecto.view.login
import com.example.proyecto.view.options
import com.example.proyecto.view.planificadorViaje
import com.example.proyecto.view.settings
import com.google.android.gms.maps.model.LatLng
import java.io.IOException
import java.util.Locale

class MainActivity : ComponentActivity() {
    private val MY_PERMISSIONS_REQUEST_LOCATION = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val loginViewModel = LoginViewModel()
            ProyectoTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login"){
                    composable("login"){ login(loginViewModel = loginViewModel, navController = navController)}
                    composable("options"){ options(loginViewModel = loginViewModel, navController = navController) }
                    composable("settings"){settings(loginViewModel = loginViewModel, navController = navController)}
                    composable("planificadorViaje"){ planificadorViaje(navController) }
                    composable("conversorMoneda"){conversorMoneda(navController)}
                    composable("calcularPropina"){ calcularPropina(navController) }
                    composable("informacionDestino"){informacionDestino(loginViewModel = loginViewModel, navController = navController)}
                    composable("historialViajes"){historialViajes(loginViewModel = loginViewModel, navController = navController)}

                }
                loginViewModel.LocationComponent(this)
            }
        }
        requestLocationPermission()
    }

    private fun requestLocationPermission() {
        // Verifica si tienes permisos, si no, solicítalos
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // No tienes permisos, solicítalos
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                MY_PERMISSIONS_REQUEST_LOCATION
            )
        }
    }
}
