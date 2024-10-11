package org.sopt.and.presentation.ui.auth

import android.app.Activity
import android.content.Context
import android.content.Intent
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.and.R
import org.sopt.and.presentation.ui.component.TextWithHorizontalDivider
import org.sopt.and.presentation.ui.component.WaveAllTopBar
import org.sopt.and.presentation.ui.component.WaveTextField
import org.sopt.and.presentation.ui.component.WaveTextFieldWithShowAndHide
import org.sopt.and.presentation.ui.my.MyActivity
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.Gray100
import org.sopt.and.ui.theme.GrayBlack
import org.sopt.and.ui.theme.White
import org.sopt.and.util.showToast
import timber.log.Timber

@AndroidEntryPoint
class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val registerViewModel: RegisterViewModel by viewModels()

        setContent {
            ANDANDROIDTheme {
                RegisterScreen(viewModel = registerViewModel, context = LocalContext.current)
            }
        }
    }
}

@Composable
fun RegisterScreen(viewModel: RegisterViewModel, context: Context) {
    val registerState by viewModel.registerState

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
            onIconClick = { (context as? Activity)?.finish() }
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
            value = registerState.email,
            onValueChange = { viewModel.onEvent(RegisterEvent.EmailChanged(it)) }
        )
        TextWithStartIcon(stringResource(R.string.register_email_information))
        WaveTextFieldWithShowAndHide(
            placeholder = stringResource(R.string.register_password),
            value = registerState.password,
            onValueChange = { viewModel.onEvent(RegisterEvent.PasswordChanged(it)) },
            showPassword = remember { mutableStateOf(registerState.showPassword) }
        )
        TextWithStartIcon(stringResource(R.string.register_password_information))
        TextWithHorizontalDivider(
            modifier = Modifier.height(70.dp),
            dividerText = stringResource(R.string.login_social_account)
        )
        SocialLoginRow()
    }
    RegisterCompleteButton(viewModel = viewModel, context = context)
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
fun RegisterCompleteButton(viewModel: RegisterViewModel, context: Context) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = stringResource(R.string.register_button),
            textAlign = TextAlign.Center,
            color = White,
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray100)
                .clickable {
                    Timber
                        .tag("[회원가입]")
                        .d("회원가입 버튼 클릭")
                    if (viewModel.checkIsValidEmail() && viewModel.checkIsValidPassword()) {
                        viewModel.apply {
                            setLocalUserEmail()
                            setLocalUserPassword()
                        }
                        (context as? Activity)?.finish()
                    } else {
                        context.apply { showToast(getString(R.string.register_toast)) }
                    }
                }
                .padding(vertical = 15.dp)
        )
    }
}
