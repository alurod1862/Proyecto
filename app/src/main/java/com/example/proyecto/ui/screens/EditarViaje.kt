package com.example.proyecto.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto.ui.components.myTopAppBarOptions
import com.example.proyecto.ui.viewmodels.WorldViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun editarViaje(navController: NavController, worldViewModel: WorldViewModel){

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {
        myTopAppBarOptions(option = "Valoracion destino visitado")

        editor(worldViewModel = worldViewModel)

    }


    Box(
        contentAlignment= Alignment.BottomEnd,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ){
        FloatingActionButton(
            onClick = {
                navController.navigate("planificadorViaje")
            },
            content = {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Agregar")
            },
            containerColor = Color(0xFF6AB7FF),
        )
    }
}


@Composable
private fun editor(worldViewModel: WorldViewModel) {
    Spacer(modifier = Modifier.size(40.dp))

    Text(text = "Puedes editar los sigueintes campos")

    Spacer(modifier = Modifier.size(40.dp))


    val pais by worldViewModel.country.observeAsState(initial = "")

    val ciudad by worldViewModel.city.observeAsState(initial = "")

    val dias by worldViewModel.days.observeAsState("")

    val idioma by worldViewModel.idiom.observeAsState(initial = "")





    TextField(
        value = pais,
        onValueChange = { worldViewModel.setCountry(it) },
        label = { Text("Pais") },
    )


    Spacer(modifier = Modifier.size(50.dp))

    TextField(
        value = ciudad,
        onValueChange = { worldViewModel.setCity(it) },
        label = { Text("Ciudad") },
    )

    Spacer(modifier = Modifier.size(50.dp))

    TextField(
        value = dias,
        onValueChange = { worldViewModel.setDays(it) },
        label = { Text("Dias") },
    )

    Spacer(modifier = Modifier.size(50.dp))

    TextField(
        value = idioma,
        onValueChange = { worldViewModel.setIdiom(it) },
        label = { Text("Idioma") },
    )

    Spacer(modifier = Modifier.size(30.dp))

    Button(onClick = { /*TODO*/ }) {
        Text(text = "Calcular")
    }

    Spacer(modifier = Modifier.size(60.dp))


}