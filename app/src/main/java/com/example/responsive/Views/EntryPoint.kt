package com.example.responsive.Views

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
            LoginCompact(navigationController, viewModel)
        }

        composable(Routes.SingUpView.route) {
            RegisterCompact(navigationController, viewModel)
        }

    }
}
