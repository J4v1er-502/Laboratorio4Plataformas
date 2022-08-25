package com.javier.myapplication

import java.io.Serializable

data class Place(
    val name: String,
    val address: String,
    val time: String,
    val phone: String
) : Serializable
