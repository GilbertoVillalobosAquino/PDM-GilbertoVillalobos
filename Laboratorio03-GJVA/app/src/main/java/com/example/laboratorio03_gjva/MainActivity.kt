package com.example.laboratorio03_gjva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Controlador de navegación
            val navController = rememberNavController()

            // Navegación entre pantallas
            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                // HOME SCREEN
                composable("home") {
                    HomePage(navController)
                }

                // PANTALLA LISTA
                composable("lista") {
                    GuardarNombres(navController)
                }

                // PANTALLA SENSORES
                composable("sensores") {
                    SensorsScreen(navController)
                }
            }
        }
    }
}
