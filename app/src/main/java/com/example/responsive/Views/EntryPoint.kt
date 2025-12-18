package com.example.responsive.Views

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.responsive.Routes
import com.example.responsive.viewModel.AppModel


@Composable
fun EntryPoint(navigationController: NavController, viewModel: AppModel) {
    NavHost(
        navController = navigationController as NavHostController,
        startDestination = Routes.LaunchScreenView.route
    ) {

        composable(Routes.LaunchScreenView.route) {
            LaunchScreen(navigationController)
        }

        composable(Routes.LogInView.route) {
            LogIn(navigationController, viewModel)
        }

        composable(Routes.SingUpView.route) {
            SingUpView(navigationController, viewModel)
        }

    }
}
