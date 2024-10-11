package org.sopt.and.presentation.ui.auth.register

import org.sopt.and.presentation.util.UiEffect
import org.sopt.and.presentation.util.UiEvent
import org.sopt.and.presentation.util.UiState

class RegisterContract {
    sealed class RegisterEvent : UiEvent {
        data class EmailChanged(val email: String) : RegisterEvent()
        data class PasswordChanged(val password: String) : RegisterEvent()
        data object PasswordVisibilityChanged : RegisterEvent()
    }

    data class RegisterState(
        val email: String = "",
        val password: String = "",
        val showPassword: Boolean = false
    ) : UiState

    sealed class RegisterEffect : UiEffect {
        data class ShowToast(val message: String) : RegisterEffect()
    }
}