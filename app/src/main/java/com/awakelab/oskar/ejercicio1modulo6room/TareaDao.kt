package com.awakelab.oskar.ejercicio1modulo6room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TareaDao {
    @Insert
    fun insertarTarea(tarea: Tarea)

    @Query("select * from tabla_tarea order by id ASC")
    fun getTareas(): List<Tarea>
}