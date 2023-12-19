package com.example.proyecto.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto.ui.components.myTopAppBarOptions
import com.example.proyecto.ui.viewmodels.LoginViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun informacionDestino(loginViewModel: LoginViewModel,navController: NavController){
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {
        myTopAppBarOptions(option = "Informacion destino")


        Spacer(modifier = Modifier.size(20.dp))

        Text(text = "Introduce el destino",fontSize =20.sp)

        Spacer(modifier = Modifier.size(20.dp))
        val destination by loginViewModel.destination.observeAsState(initial = "")
        var isConfirmed by remember { mutableStateOf(false) }
        TextField(
            value = destination,
            onValueChange = { loginViewModel.setDestination(it) },
            label = { Text("Ubicacion") },
        )
        Spacer(modifier = Modifier.size(20.dp))

        Button(onClick = {
            if(loginViewModel.returnInfoDestination(destination)) {
                isConfirmed = true
            }
        }) {
            Text(text = "Confirmar")
        }


        if(isConfirmed) {
            Text(text = "Información confirmada: ")
            var myRating1 by remember { mutableStateOf(0) }
            RatingBar(
                currentRating = myRating1,
                onRatingChanged = { myRating1 = it }
            )
        }


        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            FloatingActionButton(
                onClick = {
                    navController.navigate("options")
                },
                content = {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Agregar")
                },
                containerColor = Color(0xFF6AB7FF),
            )
        }
    }
}

