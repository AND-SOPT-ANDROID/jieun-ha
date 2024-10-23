package org.sopt.and.presentation.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val homeState by homeViewModel.uiState.collectAsState()

    LaunchedEffect(homeState.homeStatus) {
        if (homeState.homeStatus == HomeContract.HomeStatus.Idle) {
            homeViewModel.setHomeImgList()
        }
    }


    HomeScreen(
        modifier = Modifier
            .padding(paddingValues),
        bannerImgList = homeState.bannerImgList,
        numPages = homeState.bannerImgList.size.toString(),
        onCurrentPageChanged = { page ->
            homeViewModel.setCurrentBannerPage(page)
        }
    )
}