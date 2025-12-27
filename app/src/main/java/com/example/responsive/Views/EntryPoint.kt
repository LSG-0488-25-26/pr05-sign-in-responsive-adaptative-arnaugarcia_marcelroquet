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
        startDestination = Routes.LaunchScreenViewCompact.route
    ) {

        // LaunchScreen views
        composable(Routes.LaunchScreenViewCompact.route) {
            LaunchScreenCompact(navigationController, viewModel)
        }

        composable(Routes.LaunchScreenViewMedium.route) {
            LaunchScreenMedium(navigationController, viewModel)
        }

        composable(Routes.LaunchScreenViewExpanded.route) {
            LaunchScreenExpanded(navigationController, viewModel)
        }

        // Login views
        composable(Routes.LoginViewCompact.route) {
            LoginCompact(navigationController, viewModel)
        }

        composable(Routes.LoginViewMedium.route) {
            LoginMedium(navigationController, viewModel)
        }

        composable(Routes.LoginViewExpanded.route) {
            LoginExpanded(navigationController, viewModel)
        }

        // Register views
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