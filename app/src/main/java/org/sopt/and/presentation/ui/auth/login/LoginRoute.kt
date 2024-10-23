package org.sopt.and.presentation.ui.auth.login

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import org.sopt.and.R

@Composable
fun LoginRoute(
    paddingValues: PaddingValues,
    loginViewModel: LoginViewModel = hiltViewModel(),
    navigateToRegister: () -> Unit,
    navigateToHome: () -> Unit
) {
    val loginState by loginViewModel.uiState.collectAsState()
    val loginEffect = loginViewModel.uiEffect

    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    LaunchedEffect(loginEffect) {
        loginEffect.collect { loginEffect ->
            when (loginEffect) {
                is LoginContract.LoginEffect.ShowSuccessSnackBar -> {
                    coroutineScope.launch {
                        // TODO SharedSnackBar 만들어서 액티비티 이동해도 SnackBar가 뜨도록 구현
                        snackBarHostState.showSnackbar(loginEffect.successMessage)
                    }
                }

                is LoginContract.LoginEffect.ShowFailSnackBar -> {
                    coroutineScope.launch {
                        snackBarHostState.showSnackbar(loginEffect.failMessage)
                    }
                }
            }
        }
    }

    LaunchedEffect(loginState.loginStatus) {
        if (loginState.loginStatus == LoginContract.LoginStatus.Success) {
            navigateToHome()
        }
    }

    LoginScreen(
        modifier = Modifier.padding(paddingValues),
        email = loginState.email,
        password = loginState.password,
        showPassword = loginState.showPassword,
        onEmailChange = {
            loginViewModel.setEvent(
                LoginContract.LoginEvent.EmailChanged(it)
            )
        },
        onPasswordChange = {
            loginViewModel.setEvent(
                LoginContract.LoginEvent.PasswordChanged(it)
            )
        },
        onPasswordVisibilityChange = {
            loginViewModel.setEvent(
                LoginContract.LoginEvent.PasswordVisibilityChanged
            )
        },
        onLoginBtnClick = {
            loginViewModel.setEvent(
                LoginContract.LoginEvent.OnLoginBtnClicked(
                    successMessage = context.getString(R.string.login_success),
                    failMessage = context.getString(R.string.login_fail)
                )
            )
        },
        onNavigateToRegisterBtnClick = navigateToRegister,
        snackBarHostState = snackBarHostState
    )
}
