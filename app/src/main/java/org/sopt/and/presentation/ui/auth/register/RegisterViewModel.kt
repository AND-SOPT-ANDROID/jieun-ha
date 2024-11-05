package org.sopt.and.presentation.ui.auth.register

import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.and.domain.model.UserRegisterEntity
import org.sopt.and.domain.usecase.PostUserRegisterUseCase
import org.sopt.and.presentation.util.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val postUserRegisterUseCase: PostUserRegisterUseCase
) :
    BaseViewModel<RegisterContract.RegisterEvent, RegisterContract.RegisterState, RegisterContract.RegisterEffect>() {

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
            is RegisterContract.RegisterEvent.UsernameChanged -> {
                setState(currentUiState.copy(username = event.username))
                Timber.tag("[회원가입]").d("이름 변경 :${event.username}")
            }

            is RegisterContract.RegisterEvent.PasswordChanged -> {
                setState(currentUiState.copy(password = event.password))
                Timber.tag("[회원가입]").d("비밀번호 변경 : ${event.password}")
            }

            is RegisterContract.RegisterEvent.HobbyChanged -> {
                setState(currentUiState.copy(hobby = event.hobby))
                Timber.tag("[회원가입]").d("취미 변경 : ${event.hobby}")
            }

            is RegisterContract.RegisterEvent.PasswordVisibilityChanged -> {
                setState(currentUiState.copy(showPassword = !currentUiState.showPassword))
                Timber.tag("[회원가입]").d("showPassword 변경 : ${currentUiState.showPassword}")
            }

            is RegisterContract.RegisterEvent.OnRegisterBtnClicked -> {
                if (checkIsValidUsername() && checkIsValidPassword() && checkIsValidHobby()) {
                    postUserRegisterUseCase(
                        userRegisterEntity = UserRegisterEntity(
                            username = currentUiState.username,
                            userPassword = currentUiState.password,
                            userHobby = currentUiState.hobby
                        )
                    )
                    setState(currentUiState.copy(registerStatus = RegisterContract.RegisterStatus.Success))
                } else {
                    setEffect(RegisterContract.RegisterEffect.ShowToast(message = event.message))
                    setState(currentUiState.copy(registerStatus = RegisterContract.RegisterStatus.Fail))
                }
            }
        }
    }

    private fun checkIsValidUsername(): Boolean = (currentUiState.username.length <= MAX_LENGTH)

    private fun checkIsValidPassword(): Boolean = (currentUiState.password.length <= MAX_LENGTH)

    private fun checkIsValidHobby(): Boolean = (currentUiState.hobby.length <= MAX_LENGTH)

    companion object {
        const val MAX_LENGTH = 8
    }
}