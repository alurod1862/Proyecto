package com.example.proyecto.ui.screens


import androidx.compose.foundation.background
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
fun calcularPropina(navController: NavController,worldViewModel:WorldViewModel){

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {
        myTopAppBarOptions(option = "Calcular Propina")

        calculador(worldViewModel)

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
private fun calculador(worldViewModel: WorldViewModel) {
    Spacer(modifier = Modifier.size(40.dp))

    Text(text = "Introduce el pais en que te encuentas y el importe")

    Spacer(modifier = Modifier.size(40.dp))


    val country by worldViewModel.country.observeAsState(initial = "")

    val deposito2 by worldViewModel.deposito2.observeAsState("0")


    TextField(
        value = country,
        onValueChange = { worldViewModel.setCountry(it) },
        label = { Text("Introduce el pais") },
    )


    Spacer(modifier = Modifier.size(50.dp))

    TextField(
        value = deposito2,
        onValueChange = { worldViewModel.setDeposito2(it) },
        label = { Text("Introduce la cantidad") },
    )

    Spacer(modifier = Modifier.size(30.dp))

    Button(onClick = { /*TODO*/ }) {
        Text(text = "Calcular")
    }

    Spacer(modifier = Modifier.size(60.dp))

    Row(
        modifier = Modifier.width(270.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(text = "Propina: ${worldViewModel.returnTip("100")}", fontSize = 22.sp)
    }

}