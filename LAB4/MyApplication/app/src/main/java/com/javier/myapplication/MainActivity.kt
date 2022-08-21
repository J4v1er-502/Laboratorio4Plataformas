package com.javier.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnToastMessege : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnToastMessege = findViewById(R.id.constraintlayout_button_iniciar)
        initListeners()
    }
    private fun initListeners(){
        btnToastMessege.setOnClickListener{
            Toast.makeText(this, "Javier Alejandro Ramírez Heredia", Toast.LENGTH_LONG).show()
        }
    }
}