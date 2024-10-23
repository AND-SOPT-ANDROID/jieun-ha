package org.sopt.and.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import org.sopt.and.R
import org.sopt.and.presentation.model.Route
import org.sopt.and.presentation.model.WaveBottomNavigationRoute

enum class WaveBottomNavigationType(
    @DrawableRes val bnvIcon: Int,
    @StringRes val bnvText: Int,
    val route: WaveBottomNavigationRoute
) {
    HOME(
        bnvIcon = R.drawable.ic_bnv_home_32,
        bnvText = R.string.bnv_home,
        route = WaveBottomNavigationRoute.HOME
    ),
    SEARCH(
        bnvIcon = R.drawable.ic_bnv_search_32,
        bnvText = R.string.bnv_search,
        route = WaveBottomNavigationRoute.SEARCH
    ),
    MY(
        bnvIcon = R.drawable.ic_bnv_my_32,
        bnvText = R.string.bnv_my,
        route = WaveBottomNavigationRoute.MY
    );

    companion object {
        @Composable
        fun find(bnvRoute: @Composable (WaveBottomNavigationRoute) -> Boolean): WaveBottomNavigationType? {
            return entries.firstOrNull { bnvRoute(it.route) }
        }

        @Composable
        fun contains(route: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { route(it) }
        }
    }
}