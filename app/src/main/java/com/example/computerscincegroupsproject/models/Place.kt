package com.example.computerscincegroupsproject.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "Place Table", indices = [Index(value = ["GID"], unique = true)])
data class Place(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id:Int = 0,
    val GId:String,
    val name:String,
    val Type:String,
    val Pos:Int
) :Serializable {

}