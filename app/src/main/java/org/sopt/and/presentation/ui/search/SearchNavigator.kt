package org.sopt.and.presentation.ui.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.and.presentation.model.WaveBottomNavigationRoute

fun NavController.searchNavigation(navOptions: NavOptions) {
    navigate(
        route = WaveBottomNavigationRoute.SEARCH::class.simpleName.orEmpty(),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.searchNavGraph(
    paddingValues: PaddingValues
) {
    composable(route = WaveBottomNavigationRoute.SEARCH::class.simpleName.orEmpty()) {
        SearchRoute(paddingValues = paddingValues)
    }
}