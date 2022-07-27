package br.example.mylittlepig.home.data

import android.icu.text.CaseMap
import androidx.room.*
import br.example.mylittlepig.home.data.Income


@Dao
interface IncomeDAO {

    @Query("SELECT * FROM income")
    fun fecthAllIcomes(): List<Income>

    @Query("SELECT * FROM income WHERE income_tittle LIKE :title")
    fun findIncomeByTittle(title: String): Income

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIncome(Income: Income)

    @Update()
    fun updateIncome(Inocme: Income)

    @Delete
    fun deleteIncome(Income: Income)

}