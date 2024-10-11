package org.sopt.and.presentation.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.R
import org.sopt.and.presentation.ui.component.TextWithHorizontalDivider
import org.sopt.and.presentation.ui.component.ThreeTextWithVerticalDivider
import org.sopt.and.presentation.ui.component.WaveAllButton
import org.sopt.and.presentation.ui.component.WaveAllTopBar
import org.sopt.and.presentation.ui.component.WaveTextField
import org.sopt.and.presentation.ui.component.WaveTextFieldWithShowAndHide
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.GrayBlack

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ANDANDROIDTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {
    var userEmail by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }
    val showPassword = remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(GrayBlack)
            .padding(horizontal = 15.dp),
    ) {
        WaveAllTopBar(
            title = stringResource(R.string.login_title),
            position = Alignment.CenterStart,
            icon = R.drawable.ic_arrow_back_btn_24,
            onIconClick = { Log.d("클릭", "안녕") }
        )
        Spacer(modifier = Modifier.height(30.dp))
        WaveTextField(
            placeholder = stringResource(R.string.login_id_hint),
            value = userEmail,
            onValueChange = { userEmail = it }
        )
        WaveTextFieldWithShowAndHide(
            placeholder = stringResource(R.string.login_password_hint),
            value = userPassword,
            onValueChange = { userPassword = it },
            showPassword = showPassword
        )
        Spacer(modifier = Modifier.height(25.dp))
        WaveAllButton(
            buttonText = stringResource(R.string.login_button),
            onClickButton = { Log.d("클릭", "안녕") }
        )
        Spacer(modifier = Modifier.height(25.dp))
        ThreeTextWithVerticalDivider(
            dividerLeftText = stringResource(R.string.login_find_id),
            dividerCenterText = stringResource(R.string.login_find_password),
            dividerRightText = stringResource(R.string.register),
            onDividerRightTextClick = { navigateToRegisterActivity() }
        )
        TextWithHorizontalDivider(
            modifier = Modifier.height(50.dp),
            dividerText = stringResource(R.string.login_social_account)
        )
        SocialLoginRow()
    }

}

private fun navigateToRegisterActivity() {

}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    ANDANDROIDTheme {
        LoginScreen()
    }
}
