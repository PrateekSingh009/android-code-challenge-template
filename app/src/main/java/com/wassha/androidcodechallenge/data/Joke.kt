package com.wassha.androidcodechallenge.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Jokes")
data class Joke(
    @SerializedName("joke")
    val joke : String,
    @PrimaryKey
    @SerializedName("id")
    val id : String,
    @SerializedName("category")
    val category: String,
    @SerializedName("type")
    val type : String
)