package org.sopt.and.presentation.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.R
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.GrayBlack
import org.sopt.and.ui.theme.White
import timber.log.Timber

@Composable
fun WaveAllTopBar(
    title: String,
    position: Alignment,
    @DrawableRes icon: Int,
    onIconClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(GrayBlack)
            .padding(vertical = 12.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = White
        )

        Icon(
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .align(position)
                .padding(10.dp)
                .clickable { onIconClick() },
            tint = White,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WaveAllTopBarPreview() {
    ANDANDROIDTheme {
        WaveAllTopBar(
            title = "Wavve",
            position = Alignment.CenterStart,
            icon = R.drawable.ic_arrow_back_btn_24,
            onIconClick = { Timber.tag("WaveAllTopBar").d("icon clcked") }
        )
    }
}
