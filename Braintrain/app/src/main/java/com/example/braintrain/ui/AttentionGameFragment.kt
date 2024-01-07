package com.example.braintrain.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.braintrain.R
import com.example.braintrain.databinding.FragmentAttentionGameBinding

class AttentionGameFragment : Fragment() {

    private lateinit var binding: FragmentAttentionGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_attention_game, container, false)

        setupClickListeners()

        return binding.root
    }

    private fun setupClickListeners() {
        with(binding) {
            // Replace R.id.xxx with the actual IDs of your ImageViews in fragment_attention_game.xml
            val ans11 = ans11
            val ans12 = ans12
            val ans21 = ans21
            val ans22 = ans22
            val ans31 = ans31
            val ans32 = ans32
            val ans41 = ans41
            val ans42 = ans42
            val ans51 = ans51
            val ans52 = ans52

            //region 1st
            ans11.setOnClickListener {
                ans11.setImageResource(R.drawable.circlestyle3)
                ans12.setImageResource(R.drawable.circlestyle3)
            }

            ans12.setOnClickListener {
                ans11.setImageResource(R.drawable.circlestyle3)
                ans12.setImageResource(R.drawable.circlestyle3)
            }
            //endregion

            //region 2nd
            ans21.setOnClickListener {
                ans21.setImageResource(R.drawable.circlestyle2)
                ans22.setImageResource(R.drawable.circlestyle2)
            }

            ans22.setOnClickListener {
                ans21.setImageResource(R.drawable.circlestyle2)
                ans22.setImageResource(R.drawable.circlestyle2)
            }
            //endregion

            //region 3rd
            ans31.setOnClickListener {
                ans31.setImageResource(R.drawable.circlestyle1)
                ans32.setImageResource(R.drawable.circlestyle1)
            }

            ans32.setOnClickListener {
                ans31.setImageResource(R.drawable.circlestyle1)
                ans32.setImageResource(R.drawable.circlestyle1)
            }
            //endregion

            //region 4th
            ans41.setOnClickListener {
                ans41.setImageResource(R.drawable.circlestyle3)
                ans42.setImageResource(R.drawable.circlestyle3)
            }

            ans42.setOnClickListener {
                ans41.setImageResource(R.drawable.circlestyle3)
                ans42.setImageResource(R.drawable.circlestyle3)
            }
            //endregion

            //region 5th
            ans51.setOnClickListener {
                ans51.setImageResource(R.drawable.circlestyle3)
                ans52.setImageResource(R.drawable.circlestyle3)
            }

            ans52.setOnClickListener {
                ans51.setImageResource(R.drawable.circlestyle3)
                ans52.setImageResource(R.drawable.circlestyle3)
            }
            //endregion
        }
    }
}
