package com.example.braintrain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.braintrain.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)


        binding.btnMemory.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_memoryGameFragment)
        }

        binding.howtoplay.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_guideFragment)
        }

        binding.btnLanguage.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_languageGameFragment)
        }

        binding.btnMath.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_mathGameScreenFragment)
        }

        binding.btnAttention.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_attentionGameFragment)
        }

        binding.btnScores.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_scoreFragment)
        }

        return binding.root
    }




}