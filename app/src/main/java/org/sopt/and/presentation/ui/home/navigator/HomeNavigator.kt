package org.sopt.and.presentation.ui.home.navigator

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.and.presentation.model.WaveBottomNavigationRoute
import org.sopt.and.presentation.ui.home.HomeRoute

fun NavController.homeNavigation(navOptions: NavOptions) {
    navigate(
        route = WaveBottomNavigationRoute.HOME::class.simpleName.orEmpty(),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.homeNavGraph(
    paddingValues: PaddingValues
) {
    composable(route = WaveBottomNavigationRoute.HOME::class.simpleName.orEmpty()) {
        HomeRoute(paddingValues = paddingValues)
    }
}