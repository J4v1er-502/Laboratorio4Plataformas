package com.javier.myapplication

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.snackbar.Snackbar

class DetailsActivity : AppCompatActivity() {

    private lateinit var textRestaurant: TextView
    private lateinit var textAddress: TextView
    private lateinit var textTime: TextView
    private lateinit var textPhone: TextView
    private lateinit var buttonCall: Button
    private lateinit var buttonInicioV: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

       textRestaurant = findViewById(R.id.textView_detailsActivity_Name)
       textAddress = findViewById(R.id.textView_detailsActivity_Direction)
       textTime = findViewById(R.id.textView_detailsActivity_time)
       textPhone= findViewById(R.id.textView_detailsActivity_phone)
       buttonCall = findViewById(R.id.button_detailsActivity_call)
        buttonInicioV = findViewById(R.id.button_detailsActivity_Iniciar_Visita)

        val place: Place = intent.getSerializableExtra("EXTRA_PLACE") as Place

       info(place)
       setListeners(place)

    }
    private fun info(place: Place) {
        textRestaurant.text = place.name
        textAddress.text = place.address
        textTime.text = place.time
        textPhone.text = place.phone
    }

    private fun setListeners(place: Place) {

        buttonCall.setOnClickListener{
            val intent =Intent(Intent.ACTION_DIAL, Uri.parse("tel:${place.phone}"))
            startActivity(intent)
        }
        buttonInicioV.setOnClickListener {
            checkCameraPermission()
        }

    }

    private fun hasCameraPermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED

    private fun checkCameraPermission() {
        if (!hasCameraPermission()) {
            checkRequestRationale()
        } else {
            Toast.makeText(this, "Permiso otorgado, abrir camara", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkRequestRationale() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {

                val snackbar = Snackbar.make(
                    buttonInicioV,
                    "Acceso a cámara es necesario para poder tomar fotos",
                    Snackbar.LENGTH_INDEFINITE
                )
                snackbar.setAction("Ok"){
                    requestCameraPermission()
                }
                snackbar.show()
            } else {
                requestCameraPermission()
            }
        }
    }

    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CAMERA),
            0
        )
    }



}