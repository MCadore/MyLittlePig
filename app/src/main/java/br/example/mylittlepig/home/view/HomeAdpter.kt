package br.example.mylittlepig.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import br.example.mylittlepig.databinding.IncomeItemBinding
import br.example.mylittlepig.home.data.Income

class HomeAdapter() : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    private val income: MutableList<Income> = emptyList<Income>().toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(IncomeItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(income[position])
    }

    override fun getItemCount(): Int = income.size

    inner class MyViewHolder(private val binding: IncomeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(income: Income) {
            binding.incomeTittle.text = income.income_tittle
            binding.incomeValue.text = income.income_value.toString()
        }
    }
}
