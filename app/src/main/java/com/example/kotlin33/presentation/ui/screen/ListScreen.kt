package com.example.kotlin33.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.kotlin33.presentation.navigation.Screen
import com.example.kotlin33.presentation.ui.component.FullCard
import com.example.kotlin33.presentation.viewModel.TodoViewModel

@Composable
fun ListScreen(
    navHostController: NavHostController,
    viewModel: TodoViewModel = viewModel()
) {

    // Подписываемся на StateFlow
    // StateFlow  →  MutableState  →  Compose
    // делегирование by позволяет не писать постоянно .value (отрезает слой реактивности от слоя отображения).
    // viewModel.todos возвращает StateFlow<List<TodoItem>>, а todos становится List<TodoItem>
    val todos by viewModel.todos.collectAsState()
    //todos это синтаксический доступ к getValue() и setValue() к viewModel.todos.collectAsState()
    LazyColumn(
        contentPadding = PaddingValues(
            top = 40.dp, start = 0.dp,
            end = 0.dp, bottom = 90.dp
        ),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(todos.size) { index ->
            val todo = todos[index]
            FullCard(
                item = todo,
                onClick = {
                    navHostController.navigate(Screen.TodoDetailScreen.createRoute(todo.id))
                },
                onFavoriteToggle = {
                    viewModel.toggleToDo(todo.id)
                },
            )
        }
    }
}
