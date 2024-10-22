package org.sopt.and.presentation.ui.auth.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.sopt.and.R
import org.sopt.and.presentation.ui.auth.register.RegisterActivity
import org.sopt.and.presentation.ui.auth.register.SocialLoginRow
import org.sopt.and.presentation.ui.component.TextWithHorizontalDivider
import org.sopt.and.presentation.ui.component.ThreeTextWithVerticalDivider
import org.sopt.and.presentation.ui.component.WaveAllButton
import org.sopt.and.presentation.ui.component.WaveAllTopBar
import org.sopt.and.presentation.ui.component.WaveTextField
import org.sopt.and.presentation.ui.component.WaveTextFieldWithShowAndHide
import org.sopt.and.presentation.ui.my.MyActivity
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.GrayBlack
import timber.log.Timber

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val loginViewModel: LoginViewModel by viewModels()

        setContent {
            ANDANDROIDTheme {
                val loginState by loginViewModel.uiState.collectAsState()
                val loginEffect = loginViewModel.uiEffect

                val snackBarHostState = remember { SnackbarHostState() }
                val coroutineScope = rememberCoroutineScope()

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
                        navigateToMyActivity(applicationContext)
                    }
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    LoginScreen(
                        modifier = Modifier.padding(innerPadding),
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
                                    successMessage = applicationContext.getString(R.string.login_success),
                                    failMessage = applicationContext.getString(R.string.login_fail)
                                )
                            )
                        },
                        onNavigateToRegisterBtnClick = {
                            navigateToRegisterActivity(applicationContext)
                        },
                        snackBarHostState = snackBarHostState
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    email: String,
    password: String,
    showPassword: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordVisibilityChange: () -> Unit,
    onLoginBtnClick: () -> Unit,
    onNavigateToRegisterBtnClick: () -> Unit,
    snackBarHostState: SnackbarHostState
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(GrayBlack)
            .padding(horizontal = 15.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = modifier
                .fillMaxSize(),
        ) {
            WaveAllTopBar(
                title = stringResource(R.string.login_title),
                position = Alignment.CenterStart,
                icon = R.drawable.ic_arrow_back_btn_24,
                onIconClick = { Timber.tag("버튼 클릭").d("작동 안함") }
            )

            Spacer(modifier = Modifier.height(30.dp))

            WaveTextField(
                placeholder = stringResource(R.string.login_id_hint),
                value = email,
                onValueChange = { onEmailChange(it) }
            )

            WaveTextFieldWithShowAndHide(
                placeholder = stringResource(R.string.login_password_hint),
                value = password,
                onValueChange = { onPasswordChange(it) },
                showPassword = showPassword,
                changePasswordVisibility = { onPasswordVisibilityChange() }
            )

            Spacer(modifier = Modifier.height(25.dp))

            WaveAllButton(
                buttonText = stringResource(R.string.login_button),
                onClickButton = { onLoginBtnClick() }
            )

            Spacer(modifier = Modifier.height(25.dp))

            ThreeTextWithVerticalDivider(
                dividerLeftText = stringResource(R.string.login_find_id),
                dividerCenterText = stringResource(R.string.login_find_password),
                dividerRightText = stringResource(R.string.register),
                onDividerRightTextClick = { onNavigateToRegisterBtnClick() }
            )

            TextWithHorizontalDivider(
                modifier = Modifier.height(50.dp),
                dividerText = stringResource(R.string.login_social_account)
            )

            SocialLoginRow()
        }

        SnackbarHost(
            hostState = snackBarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(vertical = 15.dp)
                .padding(WindowInsets.ime.asPaddingValues())
        )
    }
}

private fun navigateToRegisterActivity(context: Context) {
    val intent = Intent(context, RegisterActivity::class.java)
        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(intent)
}

private fun navigateToMyActivity(context: Context) {
    val intent = Intent(context, MyActivity::class.java)
        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(intent)
}


@Composable
fun LoginScreenPreview() {
    LoginScreen(
        email = "jieun@ac.kr",
        password = "password",
        showPassword = false,
        onEmailChange = {},
        onPasswordChange = {},
        onPasswordVisibilityChange = {},
        onNavigateToRegisterBtnClick = {},
        onLoginBtnClick = {},
        snackBarHostState = SnackbarHostState()
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreenPreview()
}
