package org.sopt.and.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.ui.theme.ANDANDROIDTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 15.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text("Home Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    ANDANDROIDTheme {
        HomeScreen()
    }
}