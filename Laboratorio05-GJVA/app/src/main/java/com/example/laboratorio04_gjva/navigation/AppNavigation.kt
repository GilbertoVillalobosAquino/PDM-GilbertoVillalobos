package com.example.laboratorio04_gjva.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio04_gjva.view.HomeScreen
import com.example.laboratorio04_gjva.view.TaskScreen
import com.example.laboratorio04_gjva.viewmodel.TaskViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: TaskViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            HomeScreen(navController = navController)
        }
        composable<Tasks> {
            TaskScreen(viewModel = viewModel)
        }
    }
}