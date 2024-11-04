package org.sopt.and.presentation.ui.home.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun HomeAsyncImage(
    imgUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(imgUrl)
            .crossfade(enable = true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth()
    )
}