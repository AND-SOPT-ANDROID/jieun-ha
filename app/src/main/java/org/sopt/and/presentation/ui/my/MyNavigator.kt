package org.sopt.and.presentation.ui.my

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.and.presentation.model.WaveBottomNavigationRoute

fun NavController.myNavigation(navOptions: NavOptions) {
    navigate(
        route = WaveBottomNavigationRoute.MY::class.simpleName.orEmpty(),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.myNavGraph(
    paddingValues: PaddingValues
) {
    composable(route = WaveBottomNavigationRoute.MY::class.simpleName.orEmpty()) {
        MyRoute(paddingValues = paddingValues)
    }
}