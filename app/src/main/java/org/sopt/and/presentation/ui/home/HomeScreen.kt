package org.sopt.and.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import org.sopt.and.R
import org.sopt.and.presentation.ui.component.TextWithNavigateButton
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.Gray100
import org.sopt.and.ui.theme.GrayBlack
import org.sopt.and.ui.theme.White

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    bannerImgList: List<String>,
    numPages: String,
    onCurrentPageChanged: (Int) -> Unit,
    editorRecommendedImgList: List<String>,
    todayTopRankingImgList: List<String>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(GrayBlack)
            .verticalScroll(rememberScrollState())
    ) {
        val pagerState = rememberPagerState(pageCount = { bannerImgList.size })
        val horizontalContentPadding =
            ((LocalConfiguration.current).screenWidthDp * (1F - 0.85F) / 2).dp

        // TODO PagerState 자체를 인자로 받고 아래 LaunchedEffect를 HomeRoute로 옮기기
        LaunchedEffect(pagerState.currentPage) {
            onCurrentPageChanged(pagerState.currentPage)
        }

        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = horizontalContentPadding),
        ) { page ->
            HomeBannerItem(
                bannerImg = bannerImgList[page],
                currentPage = (page + 1).toString(),
                numPages = numPages
            )
        }

        Spacer(Modifier.height(24.dp))

        TextWithNavigateButton(
            titleRes = R.string.home_editor_recommend_title
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(editorRecommendedImgList,
                key = { index, _ -> index },
                contentType = { _, item -> item }
            ) { index, item ->
                EditorRecommendedItem(recommendedItem = item)
            }
        }

        Spacer(Modifier.height(24.dp))

        TextWithNavigateButton(
            titleRes = R.string.home_today_top_ranking_title
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(todayTopRankingImgList,
                key = { index, _ -> index },
                contentType = { _, item -> item }
            ) { index, item ->
                TodayTopRankingImgList(ranking = index, rankingItem = item)
            }
        }

        Spacer(Modifier.height(12.dp))
    }
}

@Composable
fun HomeBannerItem(
    bannerImg: String,
    currentPage: String,
    numPages: String
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(bannerImg)
                .crossfade(enable = true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

        HomeBannerItemCountText(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp),
            currentPage = currentPage,
            pageCount = numPages
        )
    }
}

@Composable
fun HomeBannerItemCountText(
    modifier: Modifier = Modifier,
    currentPage: String,
    pageCount: String
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(Gray100)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = stringResource(
                id = R.string.home_banner_page_count,
                currentPage,
                pageCount
            ),
            fontSize = 10.sp
        )
    }
}

@Composable
fun EditorRecommendedItem(
    recommendedItem: String
) {
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(recommendedItem)
            .crossfade(enable = true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .size(width = 144.dp, height = 192.dp)
    )
}

@Composable
fun TodayTopRankingImgList(
    ranking: Int,
    rankingItem: String,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(rankingItem)
                .crossfade(enable = true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .size(width = 180.dp, height = 240.dp)
        )

        Text(
            text = (ranking + 1).toString(),
            color = White,
            fontSize = 42.sp,
            modifier = Modifier
                .align(Alignment.BottomStart)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    ANDANDROIDTheme {
        val homeViewModel = HomeViewModel()

        HomeScreen(
            bannerImgList = homeViewModel.mockBannerItem,
            numPages = "6",
            onCurrentPageChanged = { },
            editorRecommendedImgList = homeViewModel.mockEditorRecommendedItem,
            todayTopRankingImgList = homeViewModel.mockTodayTopRankingItem
        )
    }
}