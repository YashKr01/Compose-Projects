package com.example.composeplayground.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.composeplayground.data.utils.Constants

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (Int) -> Unit,
) {
    composable(
        route = Constants.LIST_SCREEN,
        arguments = listOf(navArgument(Constants.LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {

    }
}