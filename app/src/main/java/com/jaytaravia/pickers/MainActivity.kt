package com.jaytaravia.pickers

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Calendar

class MainActivity : AppCompatActivity() , DatePickerDialog.OnDateSetListener , TimePickerDialog.OnTimeSetListener{

    var day =0
    var month = 0
    var year = 0
    var hour = 0
    var minutes = 0

    var savedDay =0         
    var savedMonth = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinutes = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cal = Calendar.getInstance()
        displayDateAndTime.text = cal.time.toString()
//        displayDateAndTime.text= cal.weeksInWeekYear.toString()


        showDtaeAndTime.setOnClickListener {
            setInitialValues()
            val datePicker = DatePickerDialog(this,this,day,month,year)
            datePicker.show()
        }


    }
    fun setInitialValues(){
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        minutes = cal.get(Calendar.MINUTE)

    }
    



    override fun onDateSet(p0: DatePicker?, day: Int, month: Int, year: Int) {
           savedDay = day
           savedMonth = month
           savedYear = year

        val timePicker = TimePickerDialog(this,this,hour,minutes,false)
        timePicker.show()

    }

    override fun onTimeSet(p0: TimePicker?, hour: Int, minutes: Int) {
        savedHour = hour
        savedMinutes = minutes

        displayDateAndTime.text = "$savedDay-${savedMonth-1}-$savedYear" + "\n" + "$savedHour:$savedMinutes"
                              
    }
}