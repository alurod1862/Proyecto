package com.example.proyecto


import android.Manifest
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto.ui.viewmodels.WorldViewModel
import com.example.proyecto.ui.theme.ProyectoTheme
import com.example.proyecto.ui.screens.calcularPropina
import com.example.proyecto.ui.screens.conversorMoneda
import com.example.proyecto.ui.screens.editarViaje
import com.example.proyecto.ui.screens.historialViajes
import com.example.proyecto.ui.screens.informacionDestino
import com.example.proyecto.ui.screens.login.login
import com.example.proyecto.ui.screens.options.options
import com.example.proyecto.ui.screens.planificadorViaje
import com.example.proyecto.ui.screens.settings.settings
import com.example.proyecto.ui.screens.valoracionDestino

class MainActivity : ComponentActivity() {
    private val MY_PERMISSIONS_REQUEST_LOCATION = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContent {
            val worldViewModel = WorldViewModel()
            ProyectoTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login"){
                    composable("login"){ login(worldViewModel,navController) }
                    composable("options"){ options(worldViewModel,navController) }
                    composable("settings"){ settings(worldViewModel,navController) }
                    composable("planificadorViaje"){ planificadorViaje(navController,worldViewModel)}
                    composable("conversorMoneda"){ conversorMoneda(navController,worldViewModel) }
                    composable("calcularPropina"){ calcularPropina(navController,worldViewModel) }
                    composable("informacionDestino"){informacionDestino(worldViewModel,navController)}
                    composable("historialViajes"){ historialViajes(navController,worldViewModel) }
                    composable("valoracionDestino"){ valoracionDestino(navController,worldViewModel) }
                    composable("editarViaje"){ editarViaje(navController,worldViewModel) }

                }
                worldViewModel.LocationComponent(this)
            }
        }
        requestLocationPermission()
    }

    private fun requestLocationPermission() {
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
