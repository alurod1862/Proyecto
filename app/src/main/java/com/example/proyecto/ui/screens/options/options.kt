package com.example.proyecto.ui.screens.options

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto.R
import com.example.proyecto.ui.components.myBottomAppBar
import com.example.proyecto.ui.components.myTopAppBar
import com.example.proyecto.ui.viewmodels.LoginViewModel


@Composable
fun options(loginViewModel: LoginViewModel, navController: NavController){

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        myTopAppBar(navController)

        Image(painter = painterResource(id = R.drawable.mapa_mundo_official), contentDescription = "mapa", modifier = Modifier
            .height(200.dp)
            .width(300.dp))
        Button(onClick = { navController.navigate("planificadorViaje") }, modifier = Modifier
            .padding(15.dp)
            .height(50.dp)
            .width(200.dp)) {
            Text(text = "Planificador de viaje", fontSize = 14.sp)
        }
        Button(onClick = { navController.navigate("conversorMoneda") }, modifier = Modifier
            .padding(15.dp)
            .height(50.dp)
            .width(200.dp)) {
            Text(text = "Conversor moneda", fontSize = 14.sp)
        }
        Button(onClick = { navController.navigate("calcularPropina") }, modifier = Modifier
            .padding(15.dp)
            .height(50.dp)
            .width(200.dp)) {
            Text(text = "Calculadora propina", fontSize = 14.sp)
        }
        Button(onClick = { navController.navigate("informacionDestino")}, modifier = Modifier
            .padding(15.dp)
            .height(50.dp)
            .width(200.dp)) {
            Text(text = "Informacion del destino", fontSize = 14.sp)
        }
        Button(onClick = { navController.navigate("historialViajes") }, modifier = Modifier
            .padding(15.dp)
            .height(50.dp)
            .width(200.dp)) {
            Text(text = "Historial de viajes", fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.size(30.dp))


        myBottomAppBar(loginViewModel)
    }
}

