package com.example.kotlin33.presentation.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.kotlin33.presentation.ui.component.FullCard
import com.example.kotlin33.presentation.viewModel.TodoViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.kotlin33.presentation.navigation.Screen

@Composable
fun ListScreen(
    navHostController: NavHostController,
    viewModel: TodoViewModel = viewModel()
) {
    val todos by viewModel.todos.collectAsState()
    LazyColumn {
        items(todos.size) { index ->
            val todo = todos[index]
            FullCard(
                item = todo,
                onClick = {
                    navHostController.navigate(Screen.TodoDetailScreen.createRoute(todo.id))
                },
                onFavoriteToggle = {
                    viewModel.toggleToDo(todo.id)
                }
            )
        }
    }
}
