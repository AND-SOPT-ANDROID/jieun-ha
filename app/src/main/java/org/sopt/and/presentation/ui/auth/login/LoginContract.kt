package org.sopt.and.presentation.ui.auth.login

import org.sopt.and.util.base.UiEffect
import org.sopt.and.util.base.UiEvent
import org.sopt.and.util.base.UiState

class LoginContract {
    sealed class LoginEvent : UiEvent {
        data class UsernameChanged(val username: String) : LoginEvent()
        data class PasswordChanged(val password: String) : LoginEvent()
        data object PasswordVisibilityChanged : LoginEvent()
        data class OnLoginBtnClicked(val successMessage: String, val failMessage: String) :
            LoginEvent()
    }

    enum class LoginStatus {
        Idle, Success, Fail
    }

    data class LoginState(
        val username: String = "",
        val password: String = "",
        val showPassword: Boolean = false,
        val loginStatus: LoginStatus = LoginStatus.Idle
    ) : UiState

    sealed class LoginEffect : UiEffect {
        data class ShowSuccessSnackBar(val successMessage: String) : LoginEffect()
        data class ShowFailSnackBar(val failMessage: String) : LoginEffect()
    }
}