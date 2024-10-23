package org.sopt.and.presentation.ui.navigator

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.presentation.type.WaveBottomNavigationType
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.Gray100
import org.sopt.and.ui.theme.GrayBlack
import org.sopt.and.ui.theme.White

@Composable
fun WaveBottomNavigation(
    modifier: Modifier = Modifier,
    isVisible: Boolean = false,
    context: Context = LocalContext.current,
    bottomNaviItems: List<WaveBottomNavigationType>,
    currentBottomNaviItem: WaveBottomNavigationType?,
    onClickBottomNavItem: (WaveBottomNavigationType) -> Unit,
) {
    AnimatedVisibility(visible = isVisible) {
        Row(
            modifier = modifier
                .background(GrayBlack)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bottomNaviItems.forEach { item ->
                WaveBottomNavigationItem(
                    modifier = Modifier.weight(1f),
                    context = context,
                    waveBottomNavigationType = item,
                    isSelected = (currentBottomNaviItem == item),
                    onClickItem = { onClickBottomNavItem(item) },
                )
            }
        }
    }
}

@Composable
fun WaveBottomNavigationItem(
    context: Context,
    waveBottomNavigationType: WaveBottomNavigationType,
    isSelected: Boolean,
    onClickItem: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clickable(onClick = onClickItem)
            .padding(vertical = 8.dp)
            .background(if (isSelected) GrayBlack else Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            // svg 추출이 안돼서 png로 했음! 그래서 vectorResource 대신 painterResource 사용함!
            painter = painterResource(waveBottomNavigationType.bnvIcon),
            contentDescription = context.getString(waveBottomNavigationType.bnvText),
            tint = if (isSelected) White else Gray100
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = context.getString(waveBottomNavigationType.bnvText),
            fontSize = 16.sp,
            color = if (isSelected) White else Gray100
        )
    }
}

@Preview
@Composable
fun WaveBottomNavigationPreview() {
    ANDANDROIDTheme {
        WaveBottomNavigation(
            bottomNaviItems = WaveBottomNavigationType.entries.toList(),
            currentBottomNaviItem = WaveBottomNavigationType.HOME,
            onClickBottomNavItem = { }
        )
    }
}