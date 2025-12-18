package com.example.responsive

sealed class Routes(val route: String) {
    object LaunchScreenView : Routes("LaunchScreenView")

    object MenuScreenView : Routes("MenuScreenView")

    object GameScreenView : Routes("GameScreenView")

    object ResultScreenView : Routes("ResultScreenView") {

    }

}