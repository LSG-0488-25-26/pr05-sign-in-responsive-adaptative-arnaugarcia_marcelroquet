package com.example.responsive.Views

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.trivialapp.Routes
import com.example.trivialapp.viewmodel.TrivialViewModel

@Composable
fun EntryPoint(navigationController: NavController, viewModel: TrivialViewModel) {
    NavHost(
        navController = navigationController as NavHostController,
        startDestination = Routes.LaunchScreenView.route
    ) {

        composable(Routes.LaunchScreenView.route) {
            LaunchScreen(navigationController)
        }

        composable(Routes.MenuScreenView.route) {
            MenuScreen(navigationController, viewModel)
        }

        composable(Routes.GameScreenView.route) {
            GameScreen(navigationController, viewModel)
        }

        composable(Routes.ResultScreenView.route) {
            ResultsScreen(navigationController, viewModel)
        }
    }
}
