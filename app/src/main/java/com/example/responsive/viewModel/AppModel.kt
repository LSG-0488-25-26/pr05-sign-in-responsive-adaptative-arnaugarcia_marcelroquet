package com.example.responsive.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AppModel : ViewModel() {
    // camps del fomrulari
    val fullName = mutableStateOf("")
    val birthDate = mutableStateOf("")
    val email = mutableStateOf("")
    val phone = mutableStateOf("")
    val username = mutableStateOf("")
    val password = mutableStateOf("")
    val confirmPassword = mutableStateOf("")
    val acceptTerms = mutableStateOf(false)

    // missatge d'error
    val errorMessage = mutableStateOf("")

    // validació
    fun validateRegister(): String {
        errorMessage.value = when {
            fullName.value.isEmpty() -> "Name required"
            birthDate.value.isEmpty() -> "birthDate required"
            email.value.isEmpty() || !email.value.contains("@") -> "invalid email"
            phone.value.any { !it.isDigit() && it != ' ' && it != '+' } -> "only accept numbers"
            username.value.isEmpty() -> "userName required"
            password.value.length < 6 -> "password required 6 digits"
            password.value != confirmPassword.value -> "Passwords do not match."
            !acceptTerms.value -> "You must accept terms and conditions."
            else -> ""
        }
        return errorMessage.value
    }


}