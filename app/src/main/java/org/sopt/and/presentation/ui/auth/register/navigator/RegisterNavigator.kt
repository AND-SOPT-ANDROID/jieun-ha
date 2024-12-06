package org.sopt.and.presentation.ui.auth.register.navigator

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.and.presentation.ui.auth.register.RegisterRoute

fun NavController.registerNavigation() {
    navigate(
        route = RegisterRoute.REGISTER_ROUTE
    )
}

fun NavGraphBuilder.registerGraph(
    navigateToLogin: () -> Unit
) {
    composable(route = RegisterRoute.REGISTER_ROUTE) {
        RegisterRoute(
            navigateToLogin = navigateToLogin
        )
    }
}

object RegisterRoute {
    const val REGISTER_ROUTE = "register"
}