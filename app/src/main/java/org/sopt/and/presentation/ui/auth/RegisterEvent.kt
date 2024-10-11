package org.sopt.and.presentation.ui.auth

sealed class RegisterEvent {
    data class EmailChanged(val email: String): RegisterEvent()
    data class PasswordChanged(val password: String): RegisterEvent()
    data object PasswordVisibilityChanged: RegisterEvent()
}