package com.example.kotlin33.data.repository

import com.example.kotlin33.data.local.TodoJsonDataSource
import com.example.kotlin33.domain.model.TodoItem
import com.example.kotlin33.domain.repository.TodoRepository


class TodoRepositoryImpl(dataSource: TodoJsonDataSource) : TodoRepository {
    private val todosDto = dataSource.getTodosFromJson().toMutableList()

    override suspend fun getTodos(): List<TodoItem> {
        return todosDto.map { it.toDomain() }
    }

    override suspend fun toggleTodo(id: Int) {
        val index = todosDto.indexOfFirst { it.id == id }
        val old = todosDto[index]
        val updated = old.copy(isCompleted = !old.isCompleted)
        todosDto[index] = updated
    }
}