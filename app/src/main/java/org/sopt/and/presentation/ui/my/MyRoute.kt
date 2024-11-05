package org.sopt.and.presentation.ui.my

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MyRoute(
    paddingValues: PaddingValues,
    myViewModel: MyViewModel = hiltViewModel()
) {
    val userHobby by myViewModel.userHobby.collectAsStateWithLifecycle()

    MyScreen(
        modifier = Modifier.padding(paddingValues),
        userHobby = userHobby
    )
}