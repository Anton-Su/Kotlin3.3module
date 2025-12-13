package com.example.kotlin33.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin33.domain.model.TodoItem
import com.example.kotlin33.domain.usecase.GetAllTodosUseCase
import com.example.kotlin33.domain.usecase.GetTodoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


// текущий ViewModel для работы с TodoItem (по факту заглушка без DI)

class TodoViewModel(private val getAllTodosUseCase: GetAllTodosUseCase,
                    private val toggleToDoUseCase: GetTodoUseCase): ViewModel() {
    private val _todos = MutableStateFlow<List<TodoItem>>(emptyList())
    val todos = _todos.asStateFlow()

    init {
        loadTodos()
    }

    private fun loadTodos() {
        viewModelScope.launch {
            _todos.value = getAllTodosUseCase()
        }
    }

    fun toggleToDo(id: Int) {
        viewModelScope.launch {
            toggleToDoUseCase(id)
            // Update the local state after toggling
            // костыль, но update cпециальный метод для MutableStateFlow лучше чем перезагружать весь список
            //_todos.value = getAllTodosUseCase()
            _todos.update { currentList ->
                currentList.map { todo ->
                    if (todo.id == id) todo.copy(isCompleted = !todo.isCompleted)
                    else todo
                }
            }

        }
    }
}

