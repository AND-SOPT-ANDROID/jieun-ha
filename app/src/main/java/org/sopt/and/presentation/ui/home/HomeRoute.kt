package org.sopt.and.presentation.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val homeState by homeViewModel.uiState.collectAsStateWithLifecycle()
    val homeUiState: HomeContract.HomeUiState = homeState.homeInitialState

    LaunchedEffect(homeUiState) {
        if(homeState.homeInitialState == HomeContract.HomeUiState.Idle) {
            homeViewModel.setHomeImgList()
        }
    }

    when (homeUiState) {
        is HomeContract.HomeUiState.Success -> {
            val pagerState = rememberPagerState(pageCount = { homeUiState.bannerImgList.size })

            HomeScreen(
                modifier = Modifier
                    .padding(paddingValues),
                bannerImgList = homeUiState.bannerImgList,
                pagerState = pagerState,
                editorRecommendedImgList = homeUiState.editorRecommendedList,
                todayTopRankingImgList = homeUiState.todayTopRankingList
            )
        }

        else -> Unit
    }
}