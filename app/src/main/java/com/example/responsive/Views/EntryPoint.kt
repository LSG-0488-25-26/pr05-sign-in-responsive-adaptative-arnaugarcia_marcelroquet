package com.example.responsive.Views

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.responsive.Routes
import com.example.responsive.viewModel.AppModel


@Composable
fun EntryPoint(
    navigationController: NavController,
    viewModel: AppModel,
    windowSizeClass: WindowSizeClass
) {

    val startDestination = Routes.RegisterViewCompact.route



    NavHost(
        navController = navigationController as NavHostController,
        startDestination = startDestination
    ) {
        // Launch
        composable(Routes.LaunchScreenViewCompact.route) {
            LaunchScreenCompact(navigationController, viewModel)
        }

        // Login
        composable(Routes.LoginViewCompact.route) {
            LoginCompact(navigationController, viewModel)
        }
        // Register
        composable(Routes.RegisterViewCompact.route) {
            RegisterCompact(navigationController, viewModel)
        }
    }
}