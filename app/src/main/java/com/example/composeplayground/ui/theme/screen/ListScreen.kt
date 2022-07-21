package com.example.composeplayground.ui.theme.screen

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeplayground.R

@Composable
fun ListScreen(
    navigateToTaskScreen: (Int) -> Unit,
) {

    Scaffold(content = {}, floatingActionButton = {
        ListFab(navigateToTaskScreen = navigateToTaskScreen)
    })

}

@Composable
fun ListFab(
    navigateToTaskScreen: (Int) -> Unit,
) {
    FloatingActionButton(onClick = { navigateToTaskScreen(-1) }) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(R.string.add_button),
            tint = Color.White
        )
    }
}

@Composable
@Preview
fun ListScreenPreview() {
    ListScreen(navigateToTaskScreen = {

    })
}