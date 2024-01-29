package com.wassha.androidcodechallenge.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Jokes")
data class JokeEntity(
    @PrimaryKey
    val id : String,
    val joke : String,
    val category: String,
    val type : String
)