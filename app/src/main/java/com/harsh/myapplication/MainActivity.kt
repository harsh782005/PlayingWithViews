package com.harsh.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var etCollageName: EditText? = null
    var etPhoneNumber: EditText? = null
    var Button: Button? = null
    var rbYes: RadioButton? = null
    var rbNo: RadioButton? = null
    var etStudyFeild: EditText? = null
    var etName: EditText? = null
    var etEmail: EditText? = null
    var valid = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        Button = findViewById(R.id.Button)
        rbYes = findViewById(R.id.rbYes)
        rbNo = findViewById(R.id.rbNo)
        etStudyFeild = findViewById(R.id.etStudyFeild)
        etCollageName = findViewById(R.id.etCollageName)
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)



        Button?.setOnClickListener {


            if (etPhoneNumber?.text.toString().trim().isNullOrEmpty()) {
                etPhoneNumber?.error = "enter your number"
                valid = false
            } else if (etPhoneNumber?.text.toString().trim().length < 10) {
                etPhoneNumber?.error = "enter valid 10 number"
                valid = false
            }
            if (etCollageName?.text.toString().trim().isEmpty()) {
                etCollageName?.error = "enter your collage"
                valid = false
            }
            if (etName?.text.toString().trim().isEmpty()) {
                etName?.error = "enter your name"
                valid = false
            }
            if (etName?.text.toString().trim().isEmpty()) {
                etEmail?.error = "enter your e mail"
                valid = false
            }
            if (valid) {
                Toast.makeText(this, "Details Entered Successfully", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Invalid Submittion", Toast.LENGTH_LONG).show()
            }

        }


        rbYes?.setOnClickListener {}
        rbYes?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                etStudyFeild?.visibility = View.VISIBLE
            } else {
                etStudyFeild?.visibility = View.GONE
            }
        }

    }
}
