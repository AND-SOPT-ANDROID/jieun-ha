package org.sopt.and.presentation.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.Gray100
import timber.log.Timber

@Composable
fun ThreeTextWithVerticalDivider(
    dividerLeftText: String,
    dividerCenterText: String,
    dividerRightText: String,
    onDividerRightTextClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Min)
    ) {
        Text(
            text = dividerLeftText,
            color = Gray100,
            fontSize = 12.sp,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 15.dp)
        )
        VerticalDivider(
            modifier = Modifier
                .padding(vertical = 8.dp),
            color = Gray100,
            thickness = 1.dp
        )
        Text(
            text = dividerCenterText,
            color = Gray100,
            fontSize = 12.sp,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 15.dp)
        )
        VerticalDivider(
            modifier = Modifier
                .padding(vertical = 8.dp),
            color = Gray100,
            thickness = 1.dp
        )
        Text(
            text = dividerRightText,
            color = Gray100,
            fontSize = 12.sp,
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
            onDividerRightTextClick = { Timber.tag("클릭").d("클릭") }
        )
    }
}