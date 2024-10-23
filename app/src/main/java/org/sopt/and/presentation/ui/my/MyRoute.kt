package org.sopt.and.presentation.ui.my

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyRoute(
    paddingValues: PaddingValues
) {
    MyScreen(modifier = Modifier.padding(paddingValues))
}