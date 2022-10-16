package com.example.computerscincegroupsproject.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*


@Entity(
    tableName = "Doc Table",
    foreignKeys = [
        ForeignKey(entity = Subject::class,
            parentColumns = ["id"],
            childColumns = ["SubID"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Doctors(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val Email:String,
    val PhoneNumber:String,
    val age:Int,
    val nationality:String,
    val year_of_attend: Date,
    val SubID:Int
) :Serializable {
}