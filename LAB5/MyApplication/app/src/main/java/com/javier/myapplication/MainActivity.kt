package com.javier.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {

    private lateinit var buttonStart : MaterialButton
    private lateinit var buttonDownload: Button
    private lateinit var textRestaurant: TextView
    private lateinit var textAddress: TextView
    private lateinit var textTime: TextView
    private lateinit var imageDirection: ImageView
    private lateinit var buttonDetails: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart = findViewById(R.id.constraintlayout_button_iniciar)
        buttonDownload = findViewById(R.id.LinearLayout_button_Download)
        textRestaurant = findViewById(R.id.constraintlayout_textView_Restaurant)
        textAddress = findViewById(R.id.constraintlayout_textView_Adress)
        textTime = findViewById(R.id.constraintlayout_textView_Time)
        imageDirection = findViewById(R.id.constraintlayout_imageView_Direction)
        buttonDetails = findViewById(R.id.constraintlayout_button_Details)

        setListeners()
    }
    private fun setListeners(){

        buttonStart.setOnClickListener{
            Toast.makeText(this, "Javier Alejandro Ramírez Heredia", Toast.LENGTH_LONG).show()
        }

        buttonDownload.setOnClickListener{

            val intent =Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp"))
            startActivity(intent)
        }

        imageDirection.setOnClickListener{
            val location = "https://goo.gl/maps/GqgqrryDvbQXbCfV9"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(location))
            startActivity(intent)
        }

        buttonDetails.setOnClickListener{
            val intent = Intent(this, DetailsActivity::class.java)

            val place =Place(

                name = textRestaurant.text.toString(),
                address = textAddress.text.toString(),
                time = textTime.text.toString(),
                phone = "79423465"
            )
            intent.putExtra("EXTRA_PLACE", place)
            startActivity(intent)
        }


    }




}