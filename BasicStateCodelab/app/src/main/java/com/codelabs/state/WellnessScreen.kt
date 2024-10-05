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

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        StatefulCounter()
        WellnessTasksList(
            onCheckedTask = { task, isChecked ->
                // Manejar el evento de marcado de la tarea aquí
            },
            onCloseTask = { task ->
                // Manejar el evento de cierre de la tarea aquí
            }
        )
    }
}

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
