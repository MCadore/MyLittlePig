package br.example.mylittlepig.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import br.example.mylittlepig.R
import br.example.mylittlepig.databinding.FragmentUpdateIncomeBinding
import br.example.mylittlepig.home.viewModel.HomeViewModel


class UpdateIncomeFragment : Fragment() {

    private var _binding : FragmentUpdateIncomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateIncomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val viewModel : HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListners()
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.onUpdateIncome.observe(viewLifecycleOwner){ result ->
            if (result.data) navigateToHome()
            else Toast.makeText(requireContext(), "erro", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToHome() {
    }

    private fun setupListners() {
        binding.ConfirmNewIncomeBtn.setOnClickListener {
        }
    }


}