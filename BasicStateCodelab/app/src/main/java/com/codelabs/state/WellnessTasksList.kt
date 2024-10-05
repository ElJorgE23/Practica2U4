
package com.codelabs.state

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.name, // Cambia esto según tu modelo de datos
                onClose = { onCloseTask(task) }, // Llama a onCloseTask con la tarea actual
                onChecked = { isChecked -> onCheckedTask(task, isChecked) } // Maneja el evento de marcado
            )
        }
    }
}

