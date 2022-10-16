package com.example.computerscincegroupsproject.models

import java.io.Serializable

data class Subject(
    val id:Int,
    val name:String,
    val attendance:Int,
    val hours:Int
) :Serializable{
}