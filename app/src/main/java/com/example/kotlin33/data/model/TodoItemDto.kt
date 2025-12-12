package com.example.kotlin33.data.model
import com.example.kotlin33.domain.model.TodoItem

data class TodoItemDto(
    val id: Int, val title: String,
    val description: String,
    val isCompleted: Boolean
) {
    fun toDomain(): TodoItem {
        return TodoItem(
            id = id,
            title = title,
            description = description,
            isCompleted = isCompleted
        )
    }
}