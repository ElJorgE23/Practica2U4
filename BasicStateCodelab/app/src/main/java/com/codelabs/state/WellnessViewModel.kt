package com.codelabs.state

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

// Clase que representa una tarea de bienestar
data class WellnessTask(
    val id: Int,
    val label: String,
    val name: String,
    var checked: Boolean = false // Asegúrate de que 'checked' esté presente
)

class WellnessViewModel : ViewModel() {

    // Crea una lista mutable de tareas de bienestar
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    // Remueve una tarea de la lista
    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    // Cambia el estado de una tarea (completada/no completada)
    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
    }
}

// Función que genera datos de prueba
private fun getWellnessTasks(): List<WellnessTask> {
    return List(30) { i ->
        WellnessTask(i, "Task # $i", "Label # $i") // Asegúrate de proporcionar un valor para 'label'
    }
}
