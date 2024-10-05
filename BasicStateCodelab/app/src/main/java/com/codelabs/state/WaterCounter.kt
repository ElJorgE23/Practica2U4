package com.codelabs.state

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    // Maneja el estado del conteo
    var count by rememberSaveable { mutableStateOf(0) }

    Column(modifier = modifier.padding(16.dp)) {
        // Usa StatelessCounter y pasa el conteo y la función para incrementar
        StatelessCounter(count = count, onIncrement = { count++ })

        // Botón para reiniciar el conteo a cero
        Button(onClick = { count = 0 }, Modifier.padding(top = 8.dp)) {
            Text("Clear count")
        }
    }
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

@Composable
fun WellnessTaskItem(
    taskName: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(taskName, modifier = Modifier.weight(1f))
        Button(onClick = onClose) {
            Text("Close")
        }
    }
}

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    WaterCounter(modifier) // Aquí utilizamos WaterCounter
}
