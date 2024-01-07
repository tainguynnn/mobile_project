package com.example.braintrain.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.braintrain.R
import com.example.braintrain.databinding.FragmentMathGameScreenBinding


class MathGameScreenFragment : Fragment() {

    private lateinit var binding : FragmentMathGameScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_math_game_screen, container, false)

        binding.btnMathGame1.setOnClickListener{
            it.findNavController().navigate(R.id.action_mathGameScreenFragment_to_mathGameFragment)
        }

        binding.btnMathGame2.setOnClickListener {
            it.findNavController().navigate(R.id.action_mathGameScreenFragment_to_mathGame2Fragment)
        }


        return binding.root
    }


}