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
        composable(Routes.LaunchScreenViewMedium.route) {
            LaunchScreenMedium(navigationController, viewModel)
        }
        composable(Routes.LaunchScreenViewExpanded.route) {
            LaunchScreenExpanded(navigationController, viewModel)
        }

        // Login
        composable(Routes.LoginViewCompact.route) {
            LoginCompact(navigationController, viewModel)
        }
        composable(Routes.LoginViewMedium.route) {
            LoginMedium(navigationController, viewModel)
        }
        composable(Routes.LoginViewExpanded.route) {
            LoginExpanded(navigationController, viewModel)
        }

        // Register
        composable(Routes.RegisterViewCompact.route) {
            RegisterCompact(navigationController, viewModel)
        }
        composable(Routes.RegisterViewMedium.route) {
            RegisterMedium(navigationController, viewModel)
        }
        composable(Routes.RegisterViewExpanded.route) {
            RegisterExpanded(navigationController, viewModel)
        }
    }
}