package org.sopt.and.presentation.ui.auth.register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.and.R
import org.sopt.and.presentation.ui.component.TextWithHorizontalDivider
import org.sopt.and.presentation.ui.component.WaveAllTopBar
import org.sopt.and.presentation.ui.component.WaveTextField
import org.sopt.and.presentation.ui.component.WaveTextFieldWithShowAndHide
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.Gray100
import org.sopt.and.ui.theme.GrayBlack
import org.sopt.and.ui.theme.White
import org.sopt.and.util.showToast

@AndroidEntryPoint
class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val registerViewModel: RegisterViewModel by viewModels()

        setContent {
            ANDANDROIDTheme {
                val registerState by registerViewModel.uiState.collectAsState()
                val registerEffect = registerViewModel.uiEffect

                LaunchedEffect(registerEffect) {
                    registerEffect.collect { registerEffect ->
                        when (registerEffect) {
                            is RegisterContract.RegisterEffect.ShowToast -> {
                                applicationContext.showToast(registerEffect.message)
                            }
                        }
                    }
                }

                LaunchedEffect(registerState.registerStatus) {
                    if (registerState.registerStatus == RegisterContract.RegisterStatus.Success) {
                        finish()
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
                        onBackBtnClick = { finish() },
                        onRegisterBtnClick = {
                            registerViewModel.setEvent(
                                RegisterContract.RegisterEvent.OnRegisterBtnClicked(
                                    message = applicationContext.getString(R.string.register_toast),
                                )
                            )
                        },
                    )
                }
            }
        }
    }
}

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    email: String,
    password: String,
    showPassword: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordVisibilityChange: () -> Unit,
    onBackBtnClick: () -> Unit,
    onRegisterBtnClick: () -> Unit,
) {

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
            .background(GrayBlack)
            .padding(horizontal = 15.dp),
    ) {
        WaveAllTopBar(
            title = stringResource(R.string.register),
            position = Alignment.CenterEnd,
            icon = R.drawable.ic_close_btn_24,
            onIconClick = { onBackBtnClick() }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(R.string.register_title),
            fontSize = 20.sp,
            color = White
        )

        Spacer(modifier = Modifier.height(20.dp))

        WaveTextField(
            placeholder = stringResource(R.string.register_email_hint),
            value = email,
            onValueChange = { onEmailChange(it) }
        )

        TextWithStartIcon(stringResource(R.string.register_email_information))

        WaveTextFieldWithShowAndHide(
            placeholder = stringResource(R.string.register_password),
            value = password,
            onValueChange = { onPasswordChange(it) },
            showPassword = showPassword,
            changePasswordVisibility = { onPasswordVisibilityChange() }
        )

        TextWithStartIcon(stringResource(R.string.register_password_information))

        TextWithHorizontalDivider(
            modifier = Modifier.height(70.dp),
            dividerText = stringResource(R.string.login_social_account)
        )

        SocialLoginRow()
    }

    RegisterCompleteButton(onClick = { onRegisterBtnClick() }, modifier = modifier)
}

@Composable
fun TextWithStartIcon(information: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_support_24),
            contentDescription = null,
            tint = Gray100
        )
        Text(
            text = information,
            color = Gray100,
            fontSize = 12.sp
        )
    }
}

@Composable
fun SocialLoginRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        // 소셜로그인 이미지 대신 해당 icon으로 대체
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_support_24),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 10.dp),
            tint = Gray100
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_support_24),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 10.dp),
            tint = Gray100
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_support_24),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 10.dp),
            tint = Gray100
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_support_24),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 10.dp),
            tint = Gray100
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_support_24),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 10.dp),
            tint = Gray100
        )
    }

    Text(
        text = stringResource(R.string.social_account_information),
        modifier = Modifier.padding(vertical = 20.dp),
        color = Gray100,
        fontSize = 12.sp
    )
}

@Composable
fun RegisterCompleteButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = stringResource(R.string.register_button),
            textAlign = TextAlign.Center,
            color = White,
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray100)
                .clickable { onClick() }
                .padding(vertical = 15.dp)
        )
    }
}

@Composable
fun RegisterScreenPreview() {
    RegisterScreen(
        email = "jieun@ac.kr",
        password = "password",
        showPassword = false,
        onEmailChange = {},
        onPasswordChange = {},
        onPasswordVisibilityChange = {},
        onBackBtnClick = {},
        onRegisterBtnClick = {},
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    RegisterScreenPreview()
}