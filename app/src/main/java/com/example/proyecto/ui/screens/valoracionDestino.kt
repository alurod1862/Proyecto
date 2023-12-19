package com.example.proyecto.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.proyecto.ui.viewmodels.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun valoracionDestino(navController: NavController,loginViewModel: LoginViewModel){

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {
        myTopAppBarOptions(option = "Valoracion destino visitado")

        Spacer(modifier = Modifier.size(20.dp))
        val location by loginViewModel.location.observeAsState(initial = "")

        TextField(
            value = location,
            onValueChange = { loginViewModel.setLocation(it) },
            label = { Text("Ubicacion") },
        )
            Spacer(modifier = Modifier.size(50.dp))
            Text(text = "Valoracion",fontSize = 30.sp, color = MaterialTheme.colorScheme.tertiary)


        Column {
            Spacer(modifier = Modifier.size(50.dp))
            valoration(type = "Seguridad")

            Spacer(modifier = Modifier.size(50.dp))
            valoration(type = "Comida")

            Spacer(modifier = Modifier.size(50.dp))
            valoration(type = "Infraestructura")

            Spacer(modifier = Modifier.size(50.dp))
            valoration(type = "Transporte")

            Spacer(modifier = Modifier.size(50.dp))
            valoration(type = "Precio")

            Spacer(modifier = Modifier.size(30.dp))
            Button(onClick = { navController.navigate("historialViajes") }) {
                Text(text = "Publicar")
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
fun valoration(type: String) {
    Row{
        Column{
            Text(
                text = type,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Left,
                )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Column{
            var myRating1 by remember { mutableStateOf(0) }
            RatingBar(
                currentRating = myRating1,
                onRatingChanged = { myRating1 = it }
            )
        }


    }
}


@Composable
fun RatingBar(
    maxRating: Int = 5,
    currentRating: Int,
    onRatingChanged: (Int) -> Unit,
    starsColor: Color = Color.Yellow
) {
    Row {
        for (i in 1..maxRating) {
            Icon(
                imageVector = if (i <= currentRating) Icons.Filled.Star
                else Icons.Filled.StarOutline,
                contentDescription = null,
                tint = if (i <= currentRating) starsColor
                else Color.Unspecified,
                modifier = Modifier
                    .clickable { onRatingChanged(i) }
                    .padding(4.dp)
            )
        }
    }
}



