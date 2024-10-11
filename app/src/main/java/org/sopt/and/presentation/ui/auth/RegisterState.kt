package org.sopt.and.presentation.ui.auth

data class RegisterState(
    val email: String = "",
    val password: String = "",
    val showPassword: Boolean = false
)
