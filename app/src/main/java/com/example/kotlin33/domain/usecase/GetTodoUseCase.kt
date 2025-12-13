package com.example.kotlin33.domain.usecase

import com.example.kotlin33.domain.repository.TodoRepository

class GetTodoUseCase(private val repository: TodoRepository) {
    suspend operator fun invoke(id: Int) {
        return repository.toggleTodo(id)
    }
}