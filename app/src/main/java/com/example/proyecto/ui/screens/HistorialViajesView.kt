package com.example.proyecto.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyecto.ui.components.myTopAppBarOptions
import com.example.proyecto.ui.viewmodels.WorldViewModel

@Composable
fun historialViajes(navController: NavController, worldViewModel: WorldViewModel){

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {
        myTopAppBarOptions(option = "Historial Viajes")

        Spacer(modifier = Modifier.size(20.dp))

        storeViajes()

        Column{
            Spacer(modifier = Modifier.size(50.dp))

            TextField(
                value = "",
                onValueChange = { (it) },
                label = { Text("Pais") },
            )
            Spacer(modifier = Modifier.size(20.dp))

            TextField(
                value = "",
                onValueChange = { (it) },
                label = { Text("Ciudad") },
            )
            Spacer(modifier = Modifier.size(20.dp))


            TextField(
                value = "",
                onValueChange = { (it) },
                label = { Text("Dias") },
            )
            Spacer(modifier = Modifier.size(20.dp))

            Button(onClick = {
                navController.navigate("valoracionDestino")
            }) {
                Text(text = "Añadir Valoracion")
            }
        }
    }

    Box(
        contentAlignment= Alignment.BottomEnd,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ){
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


@Composable
fun storeViajes(){
    Row(
        modifier = Modifier
            .border(
                width = 8.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(9.dp)
            )
            .background(MaterialTheme.colorScheme.background)
            .width(300.dp)
            .height(300.dp)
    ){
        AddRating(note = 7)
    }
}