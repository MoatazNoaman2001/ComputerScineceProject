package com.example.computerscincegroupsproject.models

import java.util.*

data class Space(
    val id:String,
    val name: String,
    val DateOfCreation:Date,
    val Description:String,
    val Type:String,
    val Subject:String,
    val Year:String,
    val imageUri:String,
    val MainAdmin:String
)
