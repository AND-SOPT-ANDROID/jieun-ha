package org.sopt.and.presentation.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.BlueButton
import org.sopt.and.ui.theme.Gray200
import org.sopt.and.ui.theme.White
import timber.log.Timber

@Composable
fun WaveAllButton(
    buttonText: String,
    buttonColor: Color = BlueButton,
    onClickButton: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 40.dp, vertical = 15.dp),
        onClick = { onClickButton() },
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = White,
            disabledContentColor = White,
            disabledContainerColor = Gray200
        )
    ) {
        Text(text = buttonText)
    }
}

@Preview(showBackground = true)
@Composable
fun WaveAllButtonPreview() {
    ANDANDROIDTheme {
        WaveAllButton(
            buttonText = "로그인하기",
            buttonColor = BlueButton,
            onClickButton = { Timber.tag("버튼 컴포넌트").d("클릭") }
        )
    }
}