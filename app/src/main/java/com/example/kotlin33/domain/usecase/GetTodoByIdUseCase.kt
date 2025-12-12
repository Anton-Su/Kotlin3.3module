package com.example.kotlin33.domain.usecase

import com.example.kotlin33.domain.model.TodoItem
import com.example.kotlin33.domain.repository.TodoRepository

class GetTodoByIdUseCase(private val repository: TodoRepository) {
    suspend operator fun invoke(id: Int): TodoItem? {
        return repository.toggleTodo(id)
    }
}