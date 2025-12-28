package com.example.responsive.Views

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.responsive.Routes
import com.example.responsive.viewModel.AppModel

@Composable
fun EntryPoint(
    navigationController: NavHostController,
    viewModel: AppModel,
    windowSizeClass: WindowSizeClass
) {
    NavHost(
        navController = navigationController,
        startDestination = Routes.LaunchScreenViewCompact.route
    ) {

        composable(Routes.EntryRegister.route) {
            val destination = when (windowSizeClass.widthSizeClass) {
                WindowWidthSizeClass.Compact -> Routes.RegisterViewCompact.route
                WindowWidthSizeClass.Medium -> Routes.RegisterViewMedium.route
                else -> Routes.RegisterViewExpanded.route
            }

            navigationController.navigate(destination) {
                popUpTo(Routes.EntryRegister.route) { inclusive = true }
            }
        }

        composable(Routes.EntryLogin.route) {
            val destination = when (windowSizeClass.widthSizeClass) {
                WindowWidthSizeClass.Compact -> Routes.LoginViewCompact.route
                WindowWidthSizeClass.Medium -> Routes.LoginViewMedium.route
                else -> Routes.LoginViewExpanded.route
            }

            navigationController.navigate(destination) {
                popUpTo(Routes.EntryLogin.route) { inclusive = true }
            }
        }

        composable(Routes.LaunchScreenViewCompact.route) {
            LaunchScreenCompact(navigationController, viewModel)
        }
        composable(Routes.LaunchScreenViewMedium.route) {
            LaunchScreenMedium(navigationController, viewModel)
        }
        composable(Routes.LaunchScreenViewExpanded.route) {
            LaunchScreenExpanded(navigationController, viewModel)
        }

        // Login Screens
        composable(Routes.LoginViewCompact.route) {
            LoginCompact(navigationController, viewModel)
        }
        composable(Routes.LoginViewMedium.route) {
            LoginMedium(navigationController, viewModel)
        }
        composable(Routes.LoginViewExpanded.route) {
            LoginExpanded(navigationController, viewModel)
        }

        // Register Screens
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
