package com.example.busschedule.database.schedule

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Clase Appdatabase crea subclases de roondatabase para manejar nuestros Dao
@Database(entities = arrayOf(Schedule::class), version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun scheduleDao(): ScheduleDao

    //Crea una instancia de Appdatabase
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        //Mostrar La instancia de Appdatabase
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance

                instance

            }

        }



    }

}



