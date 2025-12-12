package com.example.kotlin33.presentation.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.kotlin33.domain.model.TodoItem
import com.example.kotlin33.presentation.ui.component.CardCheckbox
import com.example.kotlin33.presentation.ui.component.TodoItemInfo



@Composable
fun FullCard(
    item: TodoItem,
    onClick: () -> Unit,
    onFavoriteToggle: () -> Unit,

    ) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable {onClick()})
    {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CardCheckbox(
                checked = item.isCompleted,
                onChecked = { onFavoriteToggle() }
            )
            TodoItemInfo(
                title = item.title,
                description = item.description
            )
        }
    }
}