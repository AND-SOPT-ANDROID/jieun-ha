package org.sopt.and.presentation.ui

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.and.presentation.type.WaveBottomNavigationType
import org.sopt.and.presentation.ui.navigator.WaveBottomNavigation
import org.sopt.and.presentation.ui.navigator.WaveNavHost
import org.sopt.and.presentation.ui.navigator.WaveNavigator
import org.sopt.and.presentation.ui.navigator.rememberWaveNavigator
import org.sopt.and.ui.theme.ANDANDROIDTheme

@Composable
fun MainScreen(
    navigator: WaveNavigator = rememberWaveNavigator()
) {
    Scaffold(
        content = { paddingValues ->
            WaveNavHost(
                navigator = navigator,
                paddingValues = paddingValues
            )
        },
        bottomBar = {
            WaveBottomNavigation(
                isVisible = navigator.showBottomNavigation(),
                bottomNaviItems = WaveBottomNavigationType.entries.toList(),
                currentBottomNaviItem = navigator.currentWaveBottomNavigation,
                onClickBottomNavItem = { navigator.navigateToWaveBottomNavigation(it) },
                modifier = Modifier.navigationBarsPadding()
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    ANDANDROIDTheme {
        MainScreen()
    }
}