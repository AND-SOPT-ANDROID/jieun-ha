package org.sopt.and.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.Gray100

@Composable
fun WaveTextWithLeftIcon(
    description: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_support_24),
            contentDescription = null,
            modifier = Modifier
                .size(16.dp),
            tint = Gray100,
        )
        Text(
            text = description,
            fontSize = 12.sp,
            color = Gray100
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WaveTextWithLeftIconPreview() {
    ANDANDROIDTheme {
        WaveTextWithLeftIcon(
            description = "이런 저런 설명을 여기에 줄줄줄..."
        )
    }
}
