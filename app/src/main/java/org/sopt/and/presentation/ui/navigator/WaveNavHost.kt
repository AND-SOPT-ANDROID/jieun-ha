package org.sopt.and.presentation.ui.navigator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import org.sopt.and.presentation.ui.auth.login.loginGraph
import org.sopt.and.presentation.ui.auth.register.registerGraph
import org.sopt.and.presentation.ui.home.homeNavGraph
import org.sopt.and.presentation.ui.my.myNavGraph
import org.sopt.and.presentation.ui.search.searchNavGraph

@Composable
fun WaveNavHost(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    navigator: WaveNavigator,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        NavHost(
            navController = navigator.navHostController,
            startDestination = navigator.startDestination
        ) {
            loginGraph(
                paddingValues = paddingValues,
                navigateToRegister = navigator::navigateToRegister,
                navigateToHome = navigator::navigateToHome
            )

            registerGraph(navigateToLogin = navigator::navigateToLogin)

            homeNavGraph(paddingValues = paddingValues)

            searchNavGraph(paddingValues = paddingValues)

            myNavGraph(paddingValues = paddingValues)

        }
    }
}