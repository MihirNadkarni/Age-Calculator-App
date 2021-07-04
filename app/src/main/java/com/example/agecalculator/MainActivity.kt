package com.example.agecalculator
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

  // val editTextTextPersonName= findViewById<TextView>(R.id.editTextTextPersonName)

    fun openDateTimePicker(view: View) {

        val c= Calendar.getInstance()
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener{datePicker, yy, mm, dd ->
            var dt="$dd/${mm+1}/$yy"
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, hh, mi ->
                dt+=" $hh:$mi"
                val editTextTextPersonName= findViewById<TextView>(R.id.editTextTextPersonName)
                    editTextTextPersonName.text = dt

                val today=Date()
                val dobs=editTextTextPersonName.text.toString()
                val sdf=SimpleDateFormat("dd/MM/yyyy HH:mm")
                val dob=sdf.parse(dobs)
                val days=(today.time -dob.time)/86400000
                val hours=(today.time - dob.time)%86400000/3600000
                val minutes= (today.time - dob.time)%86400000%3600000/60000
                val sec=(today.time -dob.time)%86400000%3600000%60000/1000
                val textView=findViewById<TextView>(R.id.textView)
                textView.visibility=View.VISIBLE
                textView.text="Days=$days\nHours=$hours\nminutes=$minutes\nseconds=$sec"
            },
                c.get(Calendar.HOUR),c.get(Calendar.MINUTE),false).show()
        },
            c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()
    }

}