package org.sopt.and.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.Gray100
import org.sopt.and.ui.theme.GrayBlack

@Composable
fun TextWithHorizontalDivider(
    modifier: Modifier = Modifier,
    dividerText: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        HorizontalDivider(
            modifier = Modifier
                .align(alignment = Alignment.Center),
            color = Gray100, thickness = 2.dp
        )
        Text(
            text = dividerText,
            modifier = Modifier
                .background(GrayBlack)
                .align(Alignment.Center)
                .padding(horizontal = 5.dp),
            color = Gray100,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextWithHorizontalDividerPreview() {
    ANDANDROIDTheme {
        TextWithHorizontalDivider(
            dividerText = "또는 다른 서비스 계정으로"
        )
    }
}