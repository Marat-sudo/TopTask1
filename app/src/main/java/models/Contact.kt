package models

import android.graphics.drawable.Drawable

data class Contact(
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val city: String,
    val photoResource: Int
)