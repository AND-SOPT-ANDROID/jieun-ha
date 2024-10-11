package org.sopt.and.presentation.ui.auth

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.and.data.datasource.local.WaveLocalDataSource
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val localDataStorage: WaveLocalDataSource
) : ViewModel() {
    private val _registerState = mutableStateOf(RegisterState())
    val registerState: State<RegisterState> = _registerState

    fun onEvent(registerEvent: RegisterEvent) {
        when (registerEvent) {
            is RegisterEvent.EmailChanged -> {
                _registerState.value = _registerState.value.copy(email = registerEvent.email)
                Timber.tag("[회원가입]").d("이메일 변경 :${registerEvent.email}")
            }
            is RegisterEvent.PasswordChanged -> {
                _registerState.value = _registerState.value.copy(password = registerEvent.password)
                Timber.tag("[회원가입]").d("비밀번호 변경 : ${registerEvent.password}")
            }
            is RegisterEvent.PasswordVisibilityChanged -> {
                _registerState.value.copy(showPassword = !_registerState.value.showPassword)
            }
        }
    }

    fun checkIsValidEmail(): Boolean {
        Timber.tag("[회원가입]").d("Email 검사 ${_registerState.value.email}")
        return _registerState.value.email.matches(REGEX_EMAIL.toRegex())
    }

    fun checkIsValidPassword(): Boolean {
        Timber.tag("[회원가입]").d("비밀번호 검사 ${_registerState.value.password}")
        return _registerState.value.password.matches(REGEX_PASSWORD.toRegex())
    }

    fun setLocalUserEmail() {
        localDataStorage.userEmail = _registerState.value.email
        Timber.tag("[회원가입]").d("이메일 저장 : ${localDataStorage.userEmail}")
    }

    fun setLocalUserPassword() {
        localDataStorage.userPassword = _registerState.value.password
        Timber.tag("[회원가입]").d("비밀번호 저장 : ${localDataStorage.userPassword}")
    }

    companion object {
        const val REGEX_EMAIL = "[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$"
        const val REGEX_PASSWORD = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{8,20}$"
    }
}