package com.example.braintrain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.braintrain.databinding.FragmentLanguageGame2Binding
import com.example.braintrain.databinding.FragmentLanguageGameScreenBinding


class LanguageGameScreenFragment : Fragment() {

    private lateinit var binding : FragmentLanguageGameScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_language_game_screen, container, false)



        binding.btnLanguageGame2.setOnClickListener {
            it.findNavController().navigate(R.id.action_languageGameScreenFragment_to_languageGame2Fragment)
        }
        binding.btnLanguageGame1.setOnClickListener {
            it.findNavController().navigate(R.id.action_languageGameScreenFragment_to_languageGameFragment)
        }






        return binding.root

    }


}