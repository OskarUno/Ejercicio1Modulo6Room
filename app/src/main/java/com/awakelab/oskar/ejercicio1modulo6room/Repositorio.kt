package com.awakelab.oskar.ejercicio1modulo6room

import androidx.lifecycle.LiveData

class Repositorio(private val tareaDao: TareaDao) {
    //Insertar Tarea
    suspend fun insertTask(tarea: Tarea) {
        tareaDao.insertarTarea(tarea)
    }

    //Obtiene lista de Tareas
    fun getTareas(): LiveData<List<Tarea>> {
        return tareaDao.getTareas()
    }

}