package br.example.mylittlepig.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import br.example.mylittlepig.databinding.IncomeItemBinding
import br.example.mylittlepig.home.data.Income


class HomeAdapter(
    private val onDelete: (income: Income) -> Unit,
    private val onEdit: (income: Income) -> Unit
) : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    private val income: MutableList<Income> = emptyList<Income>().toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            IncomeItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(income[position])
    }

    override fun getItemCount(): Int = income.size

    fun addIncome(incomeList: List<Income>) {
        income.clear()
        income.addAll(incomeList)
        notifyItemInserted(income.lastIndex)
    }

    inner class MyViewHolder(private val binding: IncomeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(income: Income) {
            binding.incomeTittle.text = income.income_tittle
            binding.incomeValue.text = income.income_value.toString()
            binding.DeleteBtn.setOnClickListener { openDeleteDialog(income) }
            binding.EditBtn.setOnClickListener { onEdit.invoke(income) }
        }

        private fun openDeleteDialog(income: Income) {
            AlertDialog.Builder(binding.root.context)
                .setTitle("Are you sure that you want to delete this task?")
                .setPositiveButton("Yes, I am sure") { _, _ ->
                    onDelete.invoke(income)
                }
                .setNegativeButton(
                    "No, cancel it"
                ) { dialog, _ -> dialog?.dismiss() }
                .show()
        }
    }
}

