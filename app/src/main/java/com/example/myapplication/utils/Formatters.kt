package com.example.myapplication.utils
import java.util.Calendar
import java.text.SimpleDateFormat
object Formatters {
    val cal = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    val hourFormat = SimpleDateFormat("HH:mm")


    fun getCurrentDate(): String {
        return dateFormat.format(cal.time)
    }

    fun getCurrentHour() : String{
        return hourFormat.format(cal.time)
    }
}