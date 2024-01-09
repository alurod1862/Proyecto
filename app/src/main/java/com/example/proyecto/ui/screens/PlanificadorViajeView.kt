package com.example.proyecto.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto.ui.components.myTopAppBarOptions
import com.example.proyecto.ui.viewmodels.WorldViewModel

@Composable
fun planificadorViaje(navController: NavController,worldViewModel: WorldViewModel){

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {
        myTopAppBarOptions(option = "Planificador Viaje")

        planificador(worldViewModel,navController)

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
private fun planificador(worldViewModel: WorldViewModel,navController: NavController) {
    Spacer(modifier = Modifier.size(40.dp))

    Text(text = "Informacion del destino al que te diriges")

    Spacer(modifier = Modifier.size(40.dp))


    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background).height(500.dp).width(400.dp).padding(30.dp),
        horizontalAlignment = Alignment.Start,
        //verticalArrangement = Arrangement.Start
    ) {

    Text(text = "Pais:")
        Spacer(modifier = Modifier.size(30.dp))

    Text(text = "Ciudad:")
        Spacer(modifier = Modifier.size(30.dp))

    Text(text = "Dias:")
        Spacer(modifier = Modifier.size(30.dp))

    Text(text = "Idioma:")
        Spacer(modifier = Modifier.size(30.dp))

    Text(text = "Valoracion:")
        Spacer(modifier = Modifier.size(30.dp))

    }


    Button(onClick = {navController.navigate("editarViaje")
    }) {
        Text(text = "Editar Viaje")
    }

    Spacer(modifier = Modifier.size(60.dp))

}