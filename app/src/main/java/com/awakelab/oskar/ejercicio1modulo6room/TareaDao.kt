package com.awakelab.oskar.ejercicio1modulo6room

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TareaDao {
    @Insert
    fun insertarTarea(tarea: Tarea)
}