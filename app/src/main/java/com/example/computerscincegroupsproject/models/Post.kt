@file:JvmName("KPost")

package com.example.computerscincegroupsproject.models

import java.io.Serializable
import java.util.*

class Post(
    val uid: String ,
    val Date: Date,
    val CreatorName: String,
    val CreatorPhoneNumber: String,
    val CreatorID: String,
    val content: String
) : Serializable {
}