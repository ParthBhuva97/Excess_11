package com.example.madpractical11_20012011013

import android.content.Context
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class Note(var id:String,var title:String,var subTitle:String,var Description:String,var modifiedTime:String,var reminderTime:Long,var isReminder:Boolean) {
    fun isValid() : Boolean{
        if(title.isEmpty() || Description.isEmpty())
            return false
        return true
    }

    fun changeValue(newValue:Note){

    }

    fun getReminderText() : String {
        return "Reminder: "+ (SimpleDateFormat("MMM,dd yyyy hh:mm a") as DateFormat).format(Date(reminderTime))
    }

    fun saveNote(context: Context){
        if(isReminder){
            setReminder(context,this)
        }
    }

    fun getHour():Int{
        val cal = Calendar.getInstance()
        cal.time = Date(reminderTime)
        return cal[Calendar.HOUR_OF_DAY]
    }

    fun getMinute():Int{
        val cal = Calendar.getInstance()
        cal.time = Date(reminderTime)
        return cal[Calendar.MINUTE]
    }

    fun calcReminder(){
        if(reminderTime < System.currentTimeMillis())
            isReminder = false
    }

    override fun toString(): String {
        return "$id\n"+title+"\n"+subTitle +"\n"+Description+"\nReminder:$isReminder" +"\n"+getReminderText()
    }

    companion object{
        var idNote = 0

        fun noteIdGeneration():Int{
            idNote++
            return idNote
        }

        val REMINDER_REQUEST_CODE = 1000
        val NOTE_ID_KEY = "Id"
        val NOTE_TITLE_KEY = "Title"
        val NOTE_SUBTITLE_KEY = "SubTitle"
        val NOTE_DESCRIPTION_KEY = "Description"
        val NOTE_MODIFIED_TIME_KEY = "ModifiedTime"
        val NOTE_REMINDER_TIME_KEY = "ReminderTime"

        fun getCurrentDateTime():String{
            val cal = Calendar.getInstance()
            val df : DateFormat = SimpleDateFormat("MMM,dd yyyy hh:mm:ss a")
            return df.format(cal.time)
        }

        fun getMillis(hour:Int,min:Int):Long{
            val setcalendar = Calendar.getInstance()
            setcalendar[Calendar.HOUR_OF_DAY] = hour
            setcalendar[Calendar.MINUTE] = min
            setcalendar[Calendar.SECOND] = 0
            return setcalendar.timeInMillis
        }

        fun setReminder(context:Context,note:Note){

        }

    }
}