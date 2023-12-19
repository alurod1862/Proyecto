package com.example.proyecto.ui.screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto.ui.viewmodels.LoginViewModel
import com.example.proyecto.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun login(loginViewModel: LoginViewModel, navController: NavController) {

    val user by loginViewModel.user.observeAsState(initial = "")

    val password by loginViewModel.password.observeAsState(initial = "")

    var visible = true    /*loginViewModel.checkEmail() && loginViewModel.checkPassword()*/


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painterResource(id = R.drawable.official_logo),
            contentDescription = "email",
            Modifier.size(110.dp)
        )

        Spacer(modifier = Modifier.size(20.dp))

        Row(

        ) {
            TextField(
                value = user,
                onValueChange = { loginViewModel.setUser(it) },
                label = { Text("Email") },
            )
        }


        Spacer(modifier = Modifier.size(20.dp))

        Row(


        ) {

            var passwordVisibility by remember { mutableStateOf(false) }

            TextField(
                value = password,
                onValueChange = { loginViewModel.setPassword(it) },
                label = { Text("Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordVisibility) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    IconButton(
                        onClick = { passwordVisibility = !passwordVisibility }
                    ) {
                        Icon(
                            imageVector = if (passwordVisibility) {
                                Icons.Rounded.Visibility
                            } else {
                                Icons.Rounded.VisibilityOff
                            },
                            contentDescription = "Toggle password visibility"
                        )
                    }
                }
            )
        }

        Spacer(modifier = Modifier.size(20.dp))


        Spacer(modifier = Modifier.size(20.dp))


        Button(
            onClick = {
                      navController.navigate("options")
            },
            enabled = visible,
            shape = RoundedCornerShape(23.dp),
            border = BorderStroke(3.dp, MaterialTheme.colorScheme.primary),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
        ) {
            Text(
                text = "Login",
                fontSize = 17.sp,
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 6.dp),
            )
        }
    }
}
