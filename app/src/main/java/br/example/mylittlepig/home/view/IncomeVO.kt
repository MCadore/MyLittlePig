package br.example.mylittlepig.home.view

import androidx.room.PrimaryKey

data class IncomeVO(
    val uid: Int,
    val income_tittle: String,
    val income_value: Int,
)
