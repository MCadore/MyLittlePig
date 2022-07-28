package br.example.mylittlepig.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import br.example.mylittlepig.Error
import br.example.mylittlepig.Success
import br.example.mylittlepig.databinding.FragmentHomeBinding
import br.example.mylittlepig.home.viewModel.HomeViewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val viewModel: HomeViewModel by viewModels()
    private val adapter: HomeAdapter by lazy {
        HomeAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListners()
        setupObserver()

    }

    private fun setupObserver() {
        viewModel.onUpdateIncome.observe(viewLifecycleOwner) { income ->
            if (income.data) updateView()
            else Toast.makeText(requireContext(), ERROR_MSG, Toast.LENGTH_SHORT).show()
        }
        viewModel.onFetchIncome.observe(viewLifecycleOwner) { income ->
            when (income) {
                is Success -> setupView(income.data)
                is Error -> Toast.makeText(requireContext(), ERROR_MSG, Toast.LENGTH_SHORT).show()
                else -> {
                    onDestroy()
                }
            }
        }
    }


    private fun setupListners() {
        binding.addIncomeBtn.setOnClickListener {
        }
        binding.deleteIncomeBtm.setOnClickListener {

        }
    }

    private fun updateView() {
        viewModel.fetchAllIncome()
    }

    private fun setupView(income: List<IncomeVO>) {
        adapter.addIncome(income)
        binding.RecyclerViewContainer.adapter = adapter
    }

    companion object {
        private const val ERROR_MSG = "Ocorreu um erro"
    }

}