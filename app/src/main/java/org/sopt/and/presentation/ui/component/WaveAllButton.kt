package org.sopt.and.presentation.ui.component

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.BlueButton
import org.sopt.and.ui.theme.Gray100
import org.sopt.and.ui.theme.White

@Composable
fun WaveAllButton(
    buttonText: String,
    buttonColor: Color = BlueButton,
    enableToClick: MutableState<Boolean> = mutableStateOf(value = false),
    onClickButton: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 40.dp, vertical = 15.dp),
        enabled = enableToClick.value,
        onClick = { onClickButton() },
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = White,
            disabledContentColor = White,
            disabledContainerColor = Gray100
        )
    ) {
        Text(text = buttonText)
    }
}

@Preview(showBackground = true)
@Composable
fun WaveAllButtonPreview() {
    val enableToClick = remember { mutableStateOf(false) }

    ANDANDROIDTheme {
        WaveAllButton(
            buttonText = "로그인하기",
            buttonColor = BlueButton,
            enableToClick = enableToClick,
            onClickButton = { Log.d("버튼 컴포넌트", "클릭") }
        )
    }
}