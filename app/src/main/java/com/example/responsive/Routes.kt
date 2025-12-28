package com.example.responsive

sealed class Routes(val route: String) {
    object LaunchScreenViewCompact : Routes("LaunchScreenViewCompact")
    object LoginViewCompact : Routes("LoginViewCompact")
    object RegisterViewCompact : Routes("RegisterViewCompact")

}