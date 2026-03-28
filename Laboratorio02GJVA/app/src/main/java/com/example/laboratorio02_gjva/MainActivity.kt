package com.example.laboratorio02_gjva

import android.R.attr.label
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio02_gjva.ui.theme.Laboratorio02GJVATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Composable
fun Laboratorio02(){

    var text by remember { mutableStateOf("") }
    var lista = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp, vertical = 10.dp),
            value = text,
            onValueChange = {text = it},
            label = { Text("Nombre") }
        )

        Button(
            onClick = {
                lista.add(text)
                text = ""
            }
        ) {
            Text("Guardar")
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp, vertical = 10.dp),
            Arrangement.SpaceBetween
        ) {
            Text("Listado de nombres y\n posicion en la lista")

            Button(
                onClick = {
                    lista.clear()
                }
            ) {
                Text("Limpiar")
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth().weight(1f).padding(30.dp).border(BorderStroke(2.dp, Color.Blue))
        ) {
            LazyColumn(

            ) {
                itemsIndexed(lista){ index, nombre ->

                    Row(
                        modifier = Modifier.fillMaxWidth().padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = nombre
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

@Preview
@Composable
fun prueba() {
    Laboratorio02GJVATheme {
        Laboratorio02()
    }
}

