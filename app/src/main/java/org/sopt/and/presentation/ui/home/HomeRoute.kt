package org.sopt.and.presentation.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val homeState by homeViewModel.uiState.collectAsStateWithLifecycle()
    val pagerState = rememberPagerState(pageCount = { homeState.bannerImgList.size })

    LaunchedEffect(Unit) {
       homeViewModel.setHomeImgList()
    }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            homeViewModel.setCurrentBannerPage(page)
        }
    }

    HomeScreen(
        modifier = Modifier
            .padding(paddingValues),
        bannerImgList = homeState.bannerImgList,
        numPages = homeState.bannerImgList.size.toString(),
        pagerState = pagerState,
        editorRecommendedImgList = homeState.editorRecommendedList,
        todayTopRankingImgList = homeState.todayTopRankingList
    )
}