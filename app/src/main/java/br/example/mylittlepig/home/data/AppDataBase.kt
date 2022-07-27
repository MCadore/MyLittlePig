package br.example.mylittlepig.home.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Income::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun incomeDAO(): IncomeDAO
}