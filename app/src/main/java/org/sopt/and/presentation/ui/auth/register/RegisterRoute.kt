package org.sopt.and.presentation.ui.auth.register

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.and.R
import org.sopt.and.util.showToast

@Composable
fun RegisterRoute(
    registerViewModel: RegisterViewModel = hiltViewModel(),
    navigateToLogin: () -> Unit
) {
    val registerState by registerViewModel.uiState.collectAsState()
    val registerEffect = registerViewModel.uiEffect

    val context = LocalContext.current

    LaunchedEffect(registerEffect) {
        registerEffect.collect { registerEffect ->
            when (registerEffect) {
                is RegisterContract.RegisterEffect.ShowToast -> {
                    context.showToast(registerEffect.message)
                }
            }
        }
    }

    LaunchedEffect(registerState.registerStatus) {
        if (registerState.registerStatus == RegisterContract.RegisterStatus.Success) {
            navigateToLogin()
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        RegisterScreen(
            modifier = Modifier.padding(innerPadding),
            email = registerState.email,
            password = registerState.password,
            showPassword = registerState.showPassword,
            onEmailChange = {
                registerViewModel.setEvent(
                    RegisterContract.RegisterEvent.EmailChanged(it)
                )
            },
            onPasswordChange = {
                registerViewModel.setEvent(
                    RegisterContract.RegisterEvent.PasswordChanged(it)
                )
            },
            onPasswordVisibilityChange = {
                registerViewModel.setEvent(
                    RegisterContract.RegisterEvent.PasswordVisibilityChanged
                )
            },
            onBackBtnClick = { navigateToLogin() },
            onRegisterBtnClick = {
                registerViewModel.setEvent(
                    RegisterContract.RegisterEvent.OnRegisterBtnClicked(
                        message = context.getString(R.string.register_toast),
                    )
                )
            },
        )
    }
}