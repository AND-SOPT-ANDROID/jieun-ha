package org.sopt.and.presentation.model

sealed interface Route

sealed interface WaveBottomNavigationRoute : Route {
    data object HOME : WaveBottomNavigationRoute
    data object SEARCH : WaveBottomNavigationRoute
    data object MY : WaveBottomNavigationRoute
}