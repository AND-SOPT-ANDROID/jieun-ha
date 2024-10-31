package org.sopt.and.presentation.ui.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchRoute(
    paddingValues: PaddingValues
) {
    SearchScreen(modifier = Modifier.padding(paddingValues))
}