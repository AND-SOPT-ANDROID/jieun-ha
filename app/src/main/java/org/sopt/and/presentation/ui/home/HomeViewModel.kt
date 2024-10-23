package org.sopt.and.presentation.ui.home

import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.and.presentation.util.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() :
    BaseViewModel<HomeContract.HomeEvent, HomeContract.HomeState, HomeContract.HomeSideEffect>() {

    override fun createInitialState(): HomeContract.HomeState {
        return HomeContract.HomeState()
    }

    override fun handleEffect(effect: HomeContract.HomeSideEffect) {
        TODO("Not yet implemented")
    }

    override suspend fun handleEvent(event: HomeContract.HomeEvent) {
        TODO("Not yet implemented")
    }

    val mockBannerItem = listOf(
        "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
        "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1727073001312600950.webp",
        "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202410/1728548543503727711.webp",
        "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202410/1728609264868811411.webp",
        "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1727679685902220639.webp",
        "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1725362669902656119.webp"
    )

    val mockEditorRecommendedItem = listOf(
        "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202410/1729230112230270084.webp",
        "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202406/1717859400991205300.webp",
        "https://image.wavve.com/v1/thumbnails/480_720_20_80/BMS/TVSeason/2023/K01_T2009-0520-2.webp",
        "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202309/1694062320658347760.webp",
        "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202408/1724292857510320522.webp",
        "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202410/1729230427885490213.webp",
        "https://image.wavve.com/v1/thumbnails/480_720_20_80/movieImg/MovieGroup/2023/GMV_CI01_LE0000011263-Vertical_LogoY.webp",
        "https://image.wavve.com/v1/thumbnails/480_720_20_80/movieImg/MovieGroup/2023/GMV_CD01_WR0000011336-Vertical_LogoY_RTC.webp"
    )

    fun setCurrentBannerPage(page:Int) {
        setState(currentUiState.copy(currentBannerPage = page))
    }

    fun setHomeImgList() {
        setHomeBannerState()
        setEditorRecommendState()

        setState(currentUiState.copy(homeStatus = HomeContract.HomeStatus.Success))
    }

    private fun setHomeBannerState() {
        setState(currentUiState.copy(bannerImgList = mockBannerItem))
    }

    private fun setEditorRecommendState() {
        setState(currentUiState.copy(editorRecommendedList = mockEditorRecommendedItem))
    }
}