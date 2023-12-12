package com.example.proyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto.model.LoginViewModel
import com.example.proyecto.view.login
import com.example.proyecto.ui.theme.ProyectoTheme
import com.example.proyecto.view.options
import com.example.proyecto.view.settings


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val loginViewModel = LoginViewModel()
            ProyectoTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login"){
                    composable("login"){ login(loginViewModel = loginViewModel, navController = navController)}
                    composable("options"){ options(loginViewModel = loginViewModel, navController = navController) }
                    composable("settings"){settings(loginViewModel = loginViewModel)}
                }
            }
        }
    }
}

