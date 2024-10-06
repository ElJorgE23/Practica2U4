package com.codelabs.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList

import androidx.lifecycle.viewmodel.compose.viewModel
@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()

        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task ->
                wellnessViewModel.remove(task)
            }
        )
    }
}
private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    // Define el estado para contar el número de vasos
    var count by rememberSaveable { mutableStateOf(0) }

    // Mostrar el conteo actual
    Text("You've had $count glasses.", modifier = modifier)

    // Botón para añadir uno al conteo
    Button(
        onClick = { count++ },
        enabled = count < 10, // Deshabilitar si se llega a 10
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Text("Add one")
    }

    // Botón para reiniciar el conteo a cero
    Button(
        onClick = { count = 0 },
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Text("Clear count")
    }
}
