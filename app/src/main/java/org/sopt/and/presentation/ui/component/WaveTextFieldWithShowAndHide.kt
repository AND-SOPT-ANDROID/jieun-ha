package org.sopt.and.presentation.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.R
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.Gray100
import org.sopt.and.ui.theme.Gray200
import org.sopt.and.ui.theme.White

@Composable
fun WaveTextFieldWithShowAndHide(
    modifier: Modifier = Modifier,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit = { _ -> },
    showPassword: MutableState<Boolean> = mutableStateOf(value = false)
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        placeholder = {
            Text(
                text = placeholder,
                color = Gray100,
            )
        },
        trailingIcon = {
            Text(
                text = stringResource(id = if (!showPassword.value) R.string.password_show else R.string.password_hide),
                modifier = modifier
                    .clickable { showPassword.value = !showPassword.value }
                    .padding(horizontal = 10.dp),
                color = White
            )
        },
        visualTransformation = if (!showPassword.value) PasswordVisualTransformation() else VisualTransformation.None,
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Gray200,
            unfocusedContainerColor = Gray200,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = White,
            unfocusedTextColor = White
        ),
    )
}


@Preview
@Composable
fun WaveTextFieldWithShowAndHidePreview() {
    ANDANDROIDTheme {
        var inputText by remember { mutableStateOf("") }
        val showPassword = remember { mutableStateOf(false) }

        WaveTextFieldWithShowAndHide(
            placeholder = "힌트",
            value = inputText,
            onValueChange = { newTextValue -> inputText = newTextValue },
            showPassword = showPassword
        )
    }
}