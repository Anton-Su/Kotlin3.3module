package com.example.kotlin33.presentation.ui.component


import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun CardCheckbox(
    checked: Boolean,
    onChecked: () -> Unit
) {
    Checkbox(
        checked = checked,
        onCheckedChange = { onChecked() },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Blue,
            uncheckedColor = Color.Gray,
            checkmarkColor = Color.Green
        )
    )
}



