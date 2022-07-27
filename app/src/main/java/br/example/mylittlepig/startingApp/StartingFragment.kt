package br.example.mylittlepig.startingApp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import br.example.mylittlepig.home.view.HomeActivity
import br.example.mylittlepig.databinding.FragmentStartingBinding


class StartingFragment : Fragment() {

    private val viewModel : StartingViewModel by viewModels()
    private var _binding : FragmentStartingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpListeners()
        setUpObservers()
    }

    private fun setUpListeners() {
        binding.startAppBtn.setOnClickListener {
            viewModel.onStartBtnPressed()
        }
    }

    private fun setUpObservers() {
        viewModel.startingLiveData.observe(viewLifecycleOwner){ isPressed ->
            if (isPressed.data) {
                val goToHome = Intent(requireContext(), HomeActivity::class.java)
                startActivity(goToHome)
            } else Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
        }
    }


}