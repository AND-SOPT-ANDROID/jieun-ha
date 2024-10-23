package org.sopt.and.presentation.ui.search

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.and.ui.theme.ANDANDROIDTheme

@Composable
fun SearchScreen() {
    Text("Search Screen")
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    ANDANDROIDTheme {
        SearchScreen()
    }
}