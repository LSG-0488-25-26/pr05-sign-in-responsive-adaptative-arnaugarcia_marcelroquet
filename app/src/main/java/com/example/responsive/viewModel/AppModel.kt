package com.example.responsive.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.responsive.model.User

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

    // Llista d'usuaris registrats
    private val _registeredUsers = mutableStateOf<List<User>>(emptyList())
    val registeredUsers: List<User> get() = _registeredUsers.value

    var currentUser = mutableStateOf(
        User(
            id = -1,
            fullName = "",
            birthDate = "",
            email = "",
            phone = "",
            username = "",
            password = "",
            acceptTerms = false
        )
    )

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
            registeredUsers.any { it.email == email.value } -> "Email already exists"
            else -> ""
        }
        if (errorMessage.value.isEmpty()) {
            registerUser();
        }
        return errorMessage.value
    }

    fun validateLogin(): String {
        errorMessage.value = ""

        if (email.value.isEmpty() || !email.value.contains("@")) {
            errorMessage.value = "Invalid email"
            return errorMessage.value
        }

        if (password.value.isEmpty()) {
            errorMessage.value = "Password required"
            return errorMessage.value
        }

        for (user in registeredUsers) {
            if (user.email == email.value) {
                if (user.password == password.value) {
                    currentUser.value = user
                    errorMessage.value = ""
                    return errorMessage.value
                } else {
                    errorMessage.value = "Incorrect password or invalid email"
                    return errorMessage.value
                }
            }
        }

        errorMessage.value = "User not found"
        return errorMessage.value
    }

    fun registerUser() {

        var idActual = 0
        // si hi ha usuaris agafar el id del últim  i sumar 1 per el nou ID
        if (!registeredUsers.isEmpty()) {
            idActual = registeredUsers.get(registeredUsers.size - 1).id
            idActual += 1;
        }

        val newUser = User(
            id = idActual,
            fullName = fullName.value,
            birthDate = birthDate.value,
            email = email.value,
            phone = phone.value,
            username = username.value,
            password = password.value,
            acceptTerms = acceptTerms.value
        )

        _registeredUsers.value = _registeredUsers.value + newUser
        clearForm()
        errorMessage.value = "User registered successfully"

    }
     fun clearForm() {
        fullName.value = ""
        birthDate.value = ""
        email.value = ""
        phone.value = ""
        username.value = ""
        password.value = ""
        confirmPassword.value = ""
        acceptTerms.value = false
    }
    fun cleanError(){
        errorMessage.value = ""
    }
    fun logout() {
        currentUser.value = User(
            id = -1,
            fullName = "",
            birthDate = "",
            email = "",
            phone = "",
            username = "",
            password = "",
            acceptTerms = false
        )
        email.value = ""
        password.value = ""
    }
    fun cleanValues(){
        email.value = ""
        password.value = ""
    }

}