package com.awakelab.oskar.ejercicio1modulo6room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tarea::class], version = 2)
abstract class TareaBaseDatos : RoomDatabase() {

    abstract fun getTaskDao(): TareaDao

    companion object {
        @Volatile
        private var INSTANCE: TareaBaseDatos? = null

        fun getDatabase(context: Context): TareaBaseDatos {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, TareaBaseDatos::class.java, "tarea_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}