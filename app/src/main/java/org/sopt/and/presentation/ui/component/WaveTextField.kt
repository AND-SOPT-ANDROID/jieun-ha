package org.sopt.and.presentation.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.Gray100
import org.sopt.and.ui.theme.Gray200
import org.sopt.and.ui.theme.White

@Composable
fun WaveTextField(
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit = { _ -> },
    modifier: Modifier = Modifier
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
        maxLines = 1,
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
fun WaveTextFieldPreview() {
    ANDANDROIDTheme {
        var inputText by remember { mutableStateOf("") }

        WaveTextField(
            placeholder = "힌트",
            value = inputText,
            onValueChange = { newTextValue -> inputText = newTextValue }
        )
    }
}