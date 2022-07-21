package com.example.composeplayground.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.composeplayground.data.utils.Action
import com.example.composeplayground.data.utils.Constants

fun NavGraphBuilder.taskComposable(
    navigateToTaskScreen: (Action) -> Unit,
) {
    composable(
        route = Constants.TASK_SCREEN,
        arguments = listOf(navArgument(Constants.TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) {

    }
}