package org.sopt.and.presentation.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.presentation.ui.component.TextWithHorizontalDivider
import org.sopt.and.presentation.ui.component.WaveAllTopBar
import org.sopt.and.presentation.ui.component.WaveTextField
import org.sopt.and.presentation.ui.component.WaveTextFieldWithShowAndHide
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.Gray100
import org.sopt.and.ui.theme.GrayBlack
import org.sopt.and.ui.theme.White

class RegisterActivity : ComponentActivity() {
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
fun RegisterScreen() {
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
            title = stringResource(R.string.register),
            position = Alignment.CenterEnd,
            icon = R.drawable.ic_close_btn_24,
            onIconClick = { Log.d("클릭", "안녕") }
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
            value = userEmail,
            onValueChange = { userEmail = it }
        )
        TextWithStartIcon(stringResource(R.string.register_email_information))
        WaveTextFieldWithShowAndHide(
            placeholder = stringResource(R.string.register_password),
            value = userPassword,
            onValueChange = { userPassword = it },
            showPassword = showPassword
        )
        TextWithStartIcon(stringResource(R.string.register_password_information))
        TextWithHorizontalDivider(
            modifier = Modifier.height(70.dp),
            dividerText = stringResource(R.string.login_social_account)
        )
        SocialLoginRow()
    }
    RegisterCompleteButton()
}

@Composable
fun TextWithStartIcon(information: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_support_24),
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
            painter = painterResource(R.drawable.ic_support_24),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 10.dp),
            tint = Gray100
        )
        Icon(
            painter = painterResource(R.drawable.ic_support_24),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 10.dp),
            tint = Gray100
        )
        Icon(
            painter = painterResource(R.drawable.ic_support_24),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 10.dp),
            tint = Gray100
        )
        Icon(
            painter = painterResource(R.drawable.ic_support_24),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 10.dp),
            tint = Gray100
        )
        Icon(
            painter = painterResource(R.drawable.ic_support_24),
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
fun RegisterCompleteButton() {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ){
        Text(
            text = stringResource(R.string.register_button),
            textAlign = TextAlign.Center,
            color = White,
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray100)
                .clickable { }
                .padding(vertical = 15.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    ANDANDROIDTheme {
        RegisterScreen()
    }
}
