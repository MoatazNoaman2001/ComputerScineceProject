package com.example.computerscincegroupsproject.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*


@Entity(
    tableName = "Demonstrator Table",
    foreignKeys = [
        ForeignKey(entity = Doctors::class,
            parentColumns = ["id"],
            childColumns = ["DocID"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class Demonstrator(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val DocID: Int,
    val name: String,
    val Email: String,
    val PhoneNumber: String,
    val age: Int,
    val nationality: String,
    val year_of_attend: Date,
) : Serializable {


}