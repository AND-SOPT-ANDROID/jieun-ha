package org.sopt.and.presentation.ui.home

import org.sopt.and.presentation.util.UiEffect
import org.sopt.and.presentation.util.UiEvent
import org.sopt.and.presentation.util.UiState

class HomeContract {
    sealed class HomeEvent : UiEvent {

    }

    enum class HomeStatus {
        Idle, Success, Fail
    }

    data class HomeState(
        val bannerImgList: List<String> = listOf(),
        val currentBannerPage: Int = 0,
        val homeStatus: HomeStatus = HomeStatus.Idle
    ) : UiState

    sealed class HomeSideEffect: UiEffect {

    }
}