package com.example.kotlin33.presentation.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun DetailsItemInfo(
    title: String,
    description: String,
    isCompleted: Boolean
) {
    Text(text = title, style = androidx.compose.material3.MaterialTheme.typography.titleMedium)
    Text(text = description, style = androidx.compose.material3.MaterialTheme.typography.bodySmall)
    Text(text = if (isCompleted) "Выполнено" else "Не выполнено",
        style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
        color = if (isCompleted) Color.Green else Color.Red)
}
