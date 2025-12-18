package com.example.responsive


sealed class Routes(val route: String) {
    object LogInView : Routes("LogInView")

    object SingUpView : Routes("SingUpView")

    object LaunchScreenView : Routes("LaunchScreenView")

}