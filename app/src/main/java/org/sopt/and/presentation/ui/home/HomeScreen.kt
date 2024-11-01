package org.sopt.and.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.presentation.ui.component.TextWithNavigateButton
import org.sopt.and.presentation.ui.home.component.HomeAsyncImage
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
        HomeAsyncImage(
            imgUrl = bannerImg
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
    Text(
        text = stringResource(
            id = R.string.home_banner_page_count,
            currentPage,
            pageCount
        ),
        modifier = modifier
            .clip(RoundedCornerShape(15.dp))
            .background(Gray100)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        fontSize = 10.sp
    )
}

@Composable
fun EditorRecommendedItem(
    recommendedItem: String
) {
    val imageWidth = (LocalConfiguration.current.screenWidthDp.dp) / 3

    HomeAsyncImage(
        imgUrl = recommendedItem,
        modifier = Modifier
            .width(imageWidth)
            .clip(RoundedCornerShape(15.dp))
            .aspectRatio(3f / 4f)
    )
}

@Composable
fun TodayTopRankingImgList(
    ranking: Int,
    rankingItem: String,
) {
    val imageWidth = (LocalConfiguration.current.screenWidthDp.dp) / 2

    Box(
        modifier = Modifier
            .padding(start = 10.dp, bottom = 28.dp)
    ) {
        HomeAsyncImage(
            imgUrl = rankingItem,
            modifier = Modifier
                .width(imageWidth)
                .clip(RoundedCornerShape(15.dp))
                .aspectRatio(3f / 4f)
        )

        Text(
            text = (ranking + 1).toString(),
            color = White,
            fontSize = 42.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(x = (-10).dp, y = 28.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    ANDANDROIDTheme {
        HomeScreen(
            bannerImgList = listOf(""),
            numPages = "6",
            onCurrentPageChanged = { },
            editorRecommendedImgList = listOf(""),
            todayTopRankingImgList = listOf("")
        )
    }
}