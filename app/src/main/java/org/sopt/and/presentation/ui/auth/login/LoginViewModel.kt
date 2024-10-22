package org.sopt.and.presentation.ui.auth.login

import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.and.data.datasource.local.WaveLocalDataSource
import org.sopt.and.presentation.util.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val localDataSource: WaveLocalDataSource
) : BaseViewModel<LoginContract.LoginEvent, LoginContract.LoginState, LoginContract.LoginEffect>() {

    override fun createInitialState(): LoginContract.LoginState {
        return LoginContract.LoginState()
    }

    override fun handleEffect(effect: LoginContract.LoginEffect) {
        TODO("Not yet implemented")
    }

    override suspend fun handleEvent(event: LoginContract.LoginEvent) {
        when (event) {
            is LoginContract.LoginEvent.EmailChanged -> {
                setState(currentUiState.copy(email = event.email))
            }

            is LoginContract.LoginEvent.PasswordChanged -> {
                setState(currentUiState.copy(password = event.password))
            }

            is LoginContract.LoginEvent.PasswordVisibilityChanged -> {
                setState(currentUiState.copy(showPassword = !currentUiState.showPassword))
            }

            is LoginContract.LoginEvent.OnLoginBtnClicked -> {
                if (checkIsUserEmail() && checkIsUserPassword()) {
                    setEffect(LoginContract.LoginEffect.ShowSuccessSnackBar(successMessage = event.successMessage))
                    setState(currentUiState.copy(loginStatus = LoginContract.LoginStatus.Success))
                } else {
                    setEffect(LoginContract.LoginEffect.ShowFailSnackBar(failMessage = event.failMessage))
                    setState(currentUiState.copy(loginStatus = LoginContract.LoginStatus.Fail))
                }
            }
        }
    }

    private fun checkIsUserEmail(): Boolean = (currentUiState.email == localDataSource.userEmail)

    private fun checkIsUserPassword(): Boolean =
        (currentUiState.password == localDataSource.userPassword)
}