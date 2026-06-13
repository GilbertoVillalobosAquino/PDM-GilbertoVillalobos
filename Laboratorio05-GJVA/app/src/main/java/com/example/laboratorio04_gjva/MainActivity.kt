package com.example.laboratorio04_gjva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.laboratorio04_gjva.navigation.AppNavigation
import com.example.laboratorio04_gjva.ui.theme.Laboratorio04GJVATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio04GJVATheme {
                AppNavigation()
            }
        }
    }
}