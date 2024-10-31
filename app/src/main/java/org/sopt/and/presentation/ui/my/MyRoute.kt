package org.sopt.and.presentation.ui.my

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MyRoute(
    paddingValues: PaddingValues,
    myViewModel: MyViewModel = hiltViewModel()
) {
    MyScreen(
        modifier = Modifier.padding(paddingValues),
        userName = myViewModel.getLocalUserMail()
    )
}