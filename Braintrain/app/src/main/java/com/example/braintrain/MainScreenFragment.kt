package com.example.braintrain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.braintrain.databinding.FragmentMainScreenBinding




class MainScreenFragment : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_screen, container, false)

        binding.btnLogin.setOnClickListener{
            it.findNavController().navigate(R.id.action_mainScreenFragment_to_homeFragment)
        }
        binding.btnLoginFacebook.setOnClickListener{
            it.findNavController().navigate(R.id.action_mainScreenFragment_to_homeFragment)
        }
        binding.btnLoginGoogle.setOnClickListener{
            it.findNavController().navigate(R.id.action_mainScreenFragment_to_homeFragment)
        }

        return binding.root
    }


}