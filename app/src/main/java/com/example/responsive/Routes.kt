package com.example.responsive

sealed class Routes(val route: String) {

    object Entry : Routes("Entry")
    object EntryRegister : Routes("EntryRegister")
    object EntryLogin : Routes("EntryLogin")
    object LaunchScreenViewCompact : Routes("LaunchScreenViewCompact")
    object LaunchScreenViewMedium : Routes("LaunchScreenViewMedium")
    object LaunchScreenViewExpanded : Routes("LaunchScreenViewExpanded")

    object LoginViewCompact : Routes("LoginViewCompact")
    object LoginViewMedium : Routes("LoginViewMedium")
    object LoginViewExpanded : Routes("LoginViewExpanded")

    object RegisterViewCompact : Routes("RegisterViewCompact")
    object RegisterViewMedium : Routes("RegisterViewMedium")
    object RegisterViewExpanded : Routes("RegisterViewExpanded")
    object RegisterView : Routes("RegisterView")

}