package org.sopt.and.presentation.ui.auth.login

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavController.loginNavigation() {
    navigate(
        route = LoginRoute.LOGIN_ROUTE
    ) {
        popUpTo(graph.id) {
            inclusive = true
        }
    }
}

fun NavGraphBuilder.loginGraph(
    paddingValues: PaddingValues,
    navigateToRegister: () -> Unit,
    navigateToHome: () -> Unit
) {
    composable(route = LoginRoute.LOGIN_ROUTE) {
        LoginRoute(
            paddingValues = paddingValues,
            navigateToRegister = navigateToRegister,
            navigateToHome = navigateToHome
        )
    }
}

object LoginRoute {
    const val LOGIN_ROUTE = "login"
}