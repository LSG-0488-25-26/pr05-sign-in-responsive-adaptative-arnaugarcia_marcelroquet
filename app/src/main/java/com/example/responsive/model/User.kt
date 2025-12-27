package com.example.responsive.model

data class User(
    val id: String = "",
    val fullName: String = "",
    val birthDate: String = "",
    val email: String = "",
    val phone: String = "",
    val username: String = "",
    val password: String = "",
    val acceptTerms: Boolean = false
)