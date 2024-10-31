package org.sopt.and.presentation.ui.auth.login

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
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.R
import org.sopt.and.presentation.ui.auth.register.SocialLoginRow
import org.sopt.and.presentation.ui.component.TextWithHorizontalDivider
import org.sopt.and.presentation.ui.component.ThreeTextWithVerticalDivider
import org.sopt.and.presentation.ui.component.WaveAllButton
import org.sopt.and.presentation.ui.component.WaveAllTopBar
import org.sopt.and.presentation.ui.component.WaveTextField
import org.sopt.and.presentation.ui.component.WaveTextFieldWithShowAndHide
import org.sopt.and.ui.theme.GrayBlack
import timber.log.Timber

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
            .background(GrayBlack),
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(horizontal = 15.dp)
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
                .padding(WindowInsets.ime.asPaddingValues())
                .padding(vertical = 15.dp)
        )
    }
}

@Composable
fun LoginScreenPreview() {
    LoginScreen(
        modifier = Modifier.padding(15.dp),
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
