package org.sopt.and.presentation.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.GrayBlack

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(GrayBlack)
            .padding(horizontal = 15.dp)
    ) {
        Text("Search Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    ANDANDROIDTheme {
        SearchScreen()
    }
}