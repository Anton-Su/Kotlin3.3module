package com.example.kotlin33.presentation.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin33.data.local.TodoJsonDataSource
import com.example.kotlin33.data.repository.TodoRepositoryImpl
import com.example.kotlin33.domain.model.TodoItem
import com.example.kotlin33.domain.usecase.GetAllTodosUseCase
import com.example.kotlin33.domain.usecase.GetTodoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

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
        }
    }
}

