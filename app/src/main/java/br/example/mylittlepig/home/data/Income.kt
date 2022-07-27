package br.example.mylittlepig.home.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Income(
@PrimaryKey val uid : Int,
val income_tittle : String,
val income_value : Int,
)
