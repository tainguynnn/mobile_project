package com.example.braintrain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.braintrain.databinding.FragmentMemoryGameScreenBinding


class MemoryGameScreenFragment : Fragment() {

    private lateinit var binding: FragmentMemoryGameScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_memory_game_screen, container, false)



        binding.btnMemoryGame1.setOnClickListener {
            it.findNavController().navigate(R.id.action_memoryGameScreenFragment_to_memoryGameFragment)
        }
        binding.btnMemoryGame2.setOnClickListener {
            it.findNavController().navigate(R.id.action_memoryGameScreenFragment_to_memoryGame2Fragment)
        }



        return binding.root
    }


}