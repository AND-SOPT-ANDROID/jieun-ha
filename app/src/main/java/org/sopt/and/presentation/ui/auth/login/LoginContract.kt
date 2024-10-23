package org.sopt.and.presentation.ui.auth.login

import org.sopt.and.presentation.util.UiEffect
import org.sopt.and.presentation.util.UiEvent
import org.sopt.and.presentation.util.UiState

class LoginContract {
    sealed class LoginEvent : UiEvent {
        data class EmailChanged(val email: String) : LoginEvent()
        data class PasswordChanged(val password: String) : LoginEvent()
        data object PasswordVisibilityChanged : LoginEvent()
        data class OnLoginBtnClicked(val successMessage: String, val failMessage: String) :
            LoginEvent()
    }

    enum class LoginStatus {
        Idle, Success, Fail
    }

    data class LoginState(
        val email: String = "",
        val password: String = "",
        val showPassword: Boolean = false,
        val loginStatus: LoginStatus = LoginStatus.Idle
    ) : UiState

    sealed class LoginEffect : UiEffect {
        data class ShowSuccessSnackBar(val successMessage: String) : LoginEffect()
        data class ShowFailSnackBar(val failMessage: String) : LoginEffect()
    }
}