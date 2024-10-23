package org.sopt.and.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.and.presentation.ui.navigator.WaveNavigator
import org.sopt.and.presentation.ui.navigator.rememberWaveNavigator
import org.sopt.and.ui.theme.ANDANDROIDTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val navigator: WaveNavigator = rememberWaveNavigator()

            ANDANDROIDTheme {
                MainScreen(navigator = navigator)
            }
        }
    }
}
