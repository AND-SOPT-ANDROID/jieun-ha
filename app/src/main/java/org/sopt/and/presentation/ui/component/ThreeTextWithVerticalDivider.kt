package org.sopt.and.presentation.ui.component

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.Gray100

@Composable
fun ThreeTextWithVerticalDivider(
    modifier: Modifier = Modifier,
    dividerLeftText: String,
    dividerCenterText: String,
    dividerRightText: String,
    onDividerRightTextClick: () -> Unit
) {
    Row(
        modifier = modifier
            .height(intrinsicSize = IntrinsicSize.Min)
    ) {
        Text(
            text = dividerLeftText,
            color = Gray100,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 15.dp)
        )
        VerticalDivider(color = Gray100, thickness = 2.dp)
        Text(
            text = dividerCenterText,
            color = Gray100,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 15.dp)
        )
        VerticalDivider(color = Gray100, thickness = 2.dp)
        Text(
            text = dividerRightText,
            color = Gray100,
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 15.dp)
                .clickable { onDividerRightTextClick() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ThreeTextWithVerticalDividerPreview() {
    ANDANDROIDTheme {
        ThreeTextWithVerticalDivider(
            dividerLeftText = "아이디 찾기",
            dividerCenterText = "비밀번호 재설정",
            dividerRightText = "회원가입",
            onDividerRightTextClick = { Log.d("클릭", "클릭") }
        )
    }
}