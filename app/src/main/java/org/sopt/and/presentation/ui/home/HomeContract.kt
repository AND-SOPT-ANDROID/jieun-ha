package org.sopt.and.presentation.ui.home

import okhttp3.internal.immutableListOf
import org.sopt.and.presentation.util.UiEffect
import org.sopt.and.presentation.util.UiEvent
import org.sopt.and.presentation.util.UiState

class HomeContract {
    sealed class HomeEvent : UiEvent {

    }

    enum class HomeStatus {
        Loading, Success, Fail
    }

    data class HomeState(
        val bannerImgList: List<String> = immutableListOf(),
        val currentBannerPage: Int = 0,
        val editorRecommendedList: List<String> = immutableListOf(),
        val todayTopRankingList: List<String> = immutableListOf(),
        val homeStatus: HomeStatus = HomeStatus.Loading
    ) : UiState

    sealed class HomeSideEffect : UiEffect {

    }
}