package com.awakelab.oskar.ejercicio1modulo6room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TareaViewModel (aplicacion : Application) : AndroidViewModel(aplicacion){
    private val repositorio:Repositorio

    init{
        repositorio = Repositorio(TareaBaseDatos.getDatabase(aplicacion).getTaskDao())

    }
    fun obtenerTareas(): LiveData<List<Tarea>> {
        return repositorio.getTareas()
    }

    //viewModelScope.launch El view model crea una corrutina para ejecutar las funciones suspendidas
    fun insertarTarea(tarea: Tarea) = viewModelScope.launch{
        repositorio.insertTask(tarea)
    }

}