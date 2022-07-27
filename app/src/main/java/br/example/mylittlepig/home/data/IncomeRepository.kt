package br.example.mylittlepig.home.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class IncomeRepository(context: Context) {

    private val db = Room.databaseBuilder(context, AppDataBase::class.java, "income").build()
    private val dao = db.incomeDAO()

    suspend fun fetchAllIncome(): List<Income> =
        withContext(Dispatchers.IO){
            dao.fecthAllIcomes()
        }

    suspend fun findIncomeByTittle(tittle: String): Income =
        withContext(Dispatchers.IO){
            dao.findIncomeByTittle(tittle)
        }

    suspend fun insertIncome(income: Income) =
        withContext(Dispatchers.IO){
            dao.insertIncome(income)
        }

    suspend fun updateIncome(income: Income) =
        withContext(Dispatchers.IO){
            dao.updateIncome(income)
        }

    suspend fun deleteIncome(income : Income) =
        withContext(Dispatchers.IO){
            dao.deleteIncome(income)
        }



}