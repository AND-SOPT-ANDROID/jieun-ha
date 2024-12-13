package org.sopt.and.presentation.ui.home

import androidx.compose.foundation.pager.PagerState
import org.sopt.and.util.base.UiEffect
import org.sopt.and.util.base.UiEvent
import org.sopt.and.util.base.UiState

class HomeContract {
    sealed class HomeEvent : UiEvent {

    }

    data class HomeState(
        val homeInitialState: HomeUiState = HomeUiState.Idle,
        val pagerState: PagerState = PagerState(pageCount = { 0 })
    ) : UiState

    sealed class HomeUiState {
        data class Success(
            val bannerImgList: List<String>,
            val editorRecommendedList: List<String>,
            val todayTopRankingList: List<String>
        ) : HomeUiState()

        data object Loading : HomeUiState()

        data class Error(val message: String? = null) : HomeUiState()

        data object Idle : HomeUiState()
    }

    sealed class HomeSideEffect : UiEffect {

    }
}