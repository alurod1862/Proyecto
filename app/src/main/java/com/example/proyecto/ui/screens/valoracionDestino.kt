package com.example.proyecto.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.modifier.modifierLocalConsumer
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
            Text(text = "Valoracion",fontSize = 30.sp)



            valoration(type = "Seguridad")

            valoration(type = "Comida")

            valoration(type = "Infraestructura")

            valoration(type = "Transporte")

            valoration(type = "Precio")

            valoration(type = "Ocio")


        Spacer(modifier = Modifier.size(30.dp))
        Button(onClick = { navController.navigate("historialViajes") }) {
            Text(text = "Publicar")
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
                navController.navigate("historialViajes")
            },
            content = {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Agregar")
            },
            containerColor = Color(0xFF6AB7FF),
        )
    }
}

@Composable
private fun valoration(type: String) {

    Column(
        modifier = Modifier.padding(top = 5.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(180.dp).padding(bottom = 5.dp)

        ) {
            Text(
                text = type,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Left,
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(180.dp)
        ) {
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






