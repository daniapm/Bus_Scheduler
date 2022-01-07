package com.example.busschedule.database.schedule

import androidx.room.Dao
import androidx.room.Query


//Agregando Modelo Dao para acceder a la base de datos
@Dao
interface ScheduleDao {

    //Definimos las consultas

    @Query("SELECT * FROM schedule ORDER BY arribal_time ASC")
    fun getAll(): List<Schedule>

    @Query("SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arribal_time ASC")
    fun getByStopName(stopName : String): List<Schedule>
}