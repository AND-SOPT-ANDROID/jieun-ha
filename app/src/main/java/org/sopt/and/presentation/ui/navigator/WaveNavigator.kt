package org.sopt.and.presentation.ui.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.and.presentation.model.WaveBottomNavigationRoute
import org.sopt.and.presentation.type.WaveBottomNavigationType
import org.sopt.and.presentation.ui.auth.login.LoginRoute
import org.sopt.and.presentation.ui.auth.login.loginNavigation
import org.sopt.and.presentation.ui.auth.register.registerNavigation
import org.sopt.and.presentation.ui.home.homeNavigation
import org.sopt.and.presentation.ui.my.myNavigation
import org.sopt.and.presentation.ui.search.searchNavigation

class WaveNavigator(
    val navHostController: NavHostController
) {
    private val currentDestination: NavDestination?
        @Composable get() = navHostController.currentBackStackEntryAsState().value?.destination

    val startDestination = LoginRoute.LOGIN_ROUTE

    val currentWaveBottomNavigation: WaveBottomNavigationType?
        @Composable get() = WaveBottomNavigationType.find { waveBottomNavigationRoute ->
            currentDestination?.route == waveBottomNavigationRoute::class.simpleName
        }

    fun navigateToLogin() {
        navHostController.loginNavigation()
    }

    fun navigateToRegister() {
        navHostController.registerNavigation()
    }

    fun navigateToWaveBottomNavigation(waveBottomNavigationType: WaveBottomNavigationType) {
        navOptions {
            popUpTo(WaveBottomNavigationRoute.HOME::class.simpleName.orEmpty()) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }.let { navOptions ->
            when (waveBottomNavigationType) {
                WaveBottomNavigationType.HOME -> navHostController.homeNavigation(navOptions)
                WaveBottomNavigationType.SEARCH -> navHostController.searchNavigation(navOptions)
                WaveBottomNavigationType.MY -> navHostController.myNavigation(navOptions)
            }
        }
    }

    fun navigateToHome(navOptions: NavOptions? = null) {
        navHostController.homeNavigation(
            navOptions ?: navOptions {
                popUpTo(navHostController.graph.findStartDestination().id) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        )
    }

    @Composable
    fun showBottomNavigation(): Boolean = WaveBottomNavigationType.contains {
        currentDestination?.route == it::class.simpleName
    }
}

@Composable
fun rememberWaveNavigator(
    navHostController: NavHostController = rememberNavController()
): WaveNavigator = remember(navHostController) {
    WaveNavigator(navHostController = navHostController)
}