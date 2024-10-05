
package com.codelabs.state
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.foundation.lazy.rememberLazyListState

@Composable
fun WellnessTasksList(
    list: List<WellnessTask> = remember { getWellnessTasks() },
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    val state = rememberLazyListState() // Estado para LazyColumn

    LazyColumn(
        modifier = modifier,
        state = state // Asigna el estado a LazyColumn
    ) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.name, // Cambia esto según tu modelo de datos
                onClose = { onCloseTask(task) },
                onCheckedChange = { isChecked -> onCheckedTask(task, isChecked) }
            )
        }
    }
}
