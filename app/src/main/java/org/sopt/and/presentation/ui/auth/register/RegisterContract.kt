package org.sopt.and.presentation.ui.auth.register

import org.sopt.and.presentation.util.UiEffect
import org.sopt.and.presentation.util.UiEvent
import org.sopt.and.presentation.util.UiState

class RegisterContract {
    sealed class RegisterEvent : UiEvent {
        data class UsernameChanged(val username: String) : RegisterEvent()
        data class PasswordChanged(val password: String) : RegisterEvent()
        data class HobbyChanged(val hobby: String): RegisterEvent()
        data object PasswordVisibilityChanged : RegisterEvent()
        data class OnRegisterBtnClicked(val message: String) : RegisterEvent()
    }

    enum class RegisterStatus {
        Idle, Success, Fail
    }

    data class RegisterState(
        val username: String = "",
        val password: String = "",
        val hobby: String = "",
        val showPassword: Boolean = false,
        val registerStatus: RegisterStatus = RegisterStatus.Idle
    ) : UiState

    sealed class RegisterEffect : UiEffect {
        data class ShowToast(val message: String) : RegisterEffect()
    }
}