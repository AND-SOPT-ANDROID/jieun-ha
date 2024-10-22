package org.sopt.and.presentation.ui.auth.register

import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.and.data.datasource.local.WaveLocalDataSource
import org.sopt.and.presentation.util.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val localDataStorage: WaveLocalDataSource
) : BaseViewModel<RegisterContract.RegisterEvent, RegisterContract.RegisterState, RegisterContract.RegisterEffect>() {

    override fun createInitialState(): RegisterContract.RegisterState {
        return RegisterContract.RegisterState()
    }

    override fun handleEffect(effect: RegisterContract.RegisterEffect) {
        when (effect) {
            is RegisterContract.RegisterEffect.ShowToast -> {}
        }
    }

    override suspend fun handleEvent(event: RegisterContract.RegisterEvent) {
        when (event) {
            is RegisterContract.RegisterEvent.EmailChanged -> {
                setState(currentUiState.copy(email = event.email))
                Timber.tag("[회원가입]").d("이메일 변경 :${event.email}")
            }

            is RegisterContract.RegisterEvent.PasswordChanged -> {
                setState(currentUiState.copy(password = event.password))
                Timber.tag("[회원가입]").d("비밀번호 변경 : ${event.password}")
            }

            is RegisterContract.RegisterEvent.PasswordVisibilityChanged -> {
                setState(currentUiState.copy(showPassword = !currentUiState.showPassword))
                Timber.tag("[회원가입]").d("showPassword 변경 : ${currentUiState.showPassword}")

            }

            is RegisterContract.RegisterEvent.OnRegisterBtnClicked -> {
                if (checkIsValidEmail() && checkIsValidPassword()) {
                    setLocalUserEmail()
                    setLocalUserPassword()
                    setState(currentUiState.copy(registerStatus = RegisterContract.RegisterStatus.Success))
                } else {
                    setEffect(RegisterContract.RegisterEffect.ShowToast(message = event.message))
                    setState(currentUiState.copy(registerStatus = RegisterContract.RegisterStatus.Fail))
                }
            }
        }
    }

    private fun checkIsValidEmail(): Boolean {
        Timber.tag("[회원가입]").d("Email 검사 ${currentUiState.email}")
        return currentUiState.email.matches(REGEX_EMAIL.toRegex())
    }

    private fun checkIsValidPassword(): Boolean {
        Timber.tag("[회원가입]").d("비밀번호 검사 ${currentUiState.password}")
        return currentUiState.password.matches(REGEX_PASSWORD.toRegex())
    }

    private fun setLocalUserEmail() {
        localDataStorage.userEmail = currentUiState.email
        Timber.tag("[회원가입]").d("이메일 저장 : ${localDataStorage.userEmail}")
    }

    private fun setLocalUserPassword() {
        localDataStorage.userPassword = currentUiState.password
        Timber.tag("[회원가입]").d("비밀번호 저장 : ${localDataStorage.userPassword}")
    }

    companion object {
        const val REGEX_EMAIL = "[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$"
        const val REGEX_PASSWORD =
            "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{8,20}$"
    }
}