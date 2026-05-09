package com.example.laboratorio03_gjva

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun GuardarNombres(navController: NavController) {
    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0b101b),
            Color(0xFF232945)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGradient)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            Spacer(modifier = Modifier.padding(16.dp))

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text(text = "Volver")
            }

            Spacer(modifier = Modifier.padding(16.dp))

            Text(
                text = "Ingrese su nombre",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.padding(4.dp))

            val usuario: MutableState<String> = remember { mutableStateOf("") }

            TextField(
                value = usuario.value,
                onValueChange = { usuario.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Nombre") },

                )

            Spacer(modifier = Modifier.padding(4.dp))

            val nombresList = remember { mutableStateListOf<String>() }

            Button(
                onClick = {
                    nombresList.add(usuario.value)
                    usuario.value = ""
                }
            ) {
                Text(text = "Guardar")
            }

            Spacer(modifier = Modifier.padding(4.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,

                ) {

                Text(
                    text = "Listado de nombres y \nposición en la lista",
                    color = Color.White
                )

                Button(
                    onClick = {
                        nombresList.clear()
                    }
                ) {
                    Text(text = "Limpiar")
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .background(Color.LightGray)
            ) {

                itemsIndexed(nombresList.toList()) { index, item ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = item
                        )

                        Text(
                            text = (index + 1).toString()
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuardarNombresPreview() {
    GuardarNombres(navController = rememberNavController())
}
