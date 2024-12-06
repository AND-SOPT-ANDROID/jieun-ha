package org.sopt.and.presentation.ui.auth.login

import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.and.data.datasource.local.WaveLocalDataSource
import org.sopt.and.domain.model.UserLoginEntity
import org.sopt.and.domain.usecase.PatchUserLoginUseCase
import org.sopt.and.util.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val waveLocalDataStorage: WaveLocalDataSource,
    private val patchUserLoginUseCase: PatchUserLoginUseCase
) : BaseViewModel<LoginContract.LoginEvent, LoginContract.LoginState, LoginContract.LoginEffect>() {

    override fun createInitialState(): LoginContract.LoginState {
        return LoginContract.LoginState()
    }

    override fun handleEffect(effect: LoginContract.LoginEffect) {
        TODO("Not yet implemented")
    }

    override suspend fun handleEvent(event: LoginContract.LoginEvent) {
        when (event) {
            is LoginContract.LoginEvent.UsernameChanged -> {
                setState(currentUiState.copy(username = event.username))
            }

            is LoginContract.LoginEvent.PasswordChanged -> {
                setState(currentUiState.copy(password = event.password))
            }

            is LoginContract.LoginEvent.PasswordVisibilityChanged -> {
                setState(currentUiState.copy(showPassword = !currentUiState.showPassword))
            }

            is LoginContract.LoginEvent.OnLoginBtnClicked -> {
                patchUserLoginUseCase(
                    userLoginEntity = UserLoginEntity(
                        username = currentUiState.username,
                        userPassword = currentUiState.password
                    )
                ).onSuccess { user ->
                    Timber.d("[로그인] 성공 -> $user")
                    setEffect(LoginContract.LoginEffect.ShowSuccessSnackBar(successMessage = event.successMessage))
                    setAccessToken(user.accessToken)
                    setState(currentUiState.copy(loginStatus = LoginContract.LoginStatus.Success))
                }.onFailure {
                    Timber.d("[로그인] 실패 -> $it")
                    setEffect(LoginContract.LoginEffect.ShowFailSnackBar(failMessage = event.failMessage))
                    setState(currentUiState.copy(loginStatus = LoginContract.LoginStatus.Fail))
                }
            }
        }
    }

    private fun setAccessToken(token: String) {
        with(waveLocalDataStorage) {
            accessToken = token
            isLogin = true
        }
    }
}