package com.example.busschedule.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.database.schedule.ScheduleDao
import java.lang.IllegalArgumentException

//Definimos nuestro modelo de vista para manejar los datos
class BuusScheduleViewModel(private val scheduleDao: ScheduleDao) : ViewModel() {

    //Llamamos a los metodos de Schedule Dao
    fun fullSchedule() : List<Schedule> = scheduleDao.getAll()
    fun scheduleForStopName(name: String): List<Schedule> = scheduleDao.getByStopName(name)
}

//creamos una fabrica que crea instancias de objetos ViewModel
class BusScheduleViewModelFactory(
    private val scheduleDao: ScheduleDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BuusScheduleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BuusScheduleViewModel(scheduleDao) as T
        }
        throw IllegalArgumentException("Unknown Viewmodel class")
    }

}