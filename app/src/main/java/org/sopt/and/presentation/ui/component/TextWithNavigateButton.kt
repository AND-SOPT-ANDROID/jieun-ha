package org.sopt.and.presentation.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.ui.theme.White

@Composable
fun TextWithNavigateButton(
    @StringRes titleRes: Int,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(titleRes),
            fontSize = 20.sp,
            color = White
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_right_btn_24),
            contentDescription = null,
            tint = White
        )
    }
}

@Preview
@Composable
fun TextWithNavigateButtonPreview() {
    TextWithNavigateButton(R.string.home_editor_recommend_title)
}