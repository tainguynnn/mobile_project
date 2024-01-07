package com.example.braintrain.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.braintrain.R
import com.example.braintrain.databinding.FragmentMemoryGameBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MemoryGameFragment : Fragment(), View.OnClickListener {

    private var score = 0
    private lateinit var binding: FragmentMemoryGameBinding
    private var result: String = ""
    private var userAnswer: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMemoryGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            panel1.setOnClickListener(this@MemoryGameFragment)
            panel2.setOnClickListener(this@MemoryGameFragment)
            panel3.setOnClickListener(this@MemoryGameFragment)
            panel4.setOnClickListener(this@MemoryGameFragment)
            startGame()
        }
    }

    private fun startGame() {
        result = ""
        userAnswer = ""
        disableButtons()
        lifecycleScope.launch {
            val round = (3..5).random()
            repeat(round) {
                delay(400)
                val randomPanel = (1..4).random()
                result += randomPanel

                val panel = when (randomPanel) {
                    1 -> binding.panel1
                    2 -> binding.panel2
                    3 -> binding.panel3
                    else -> binding.panel4
                }

                val drawableYellow =
                    ActivityCompat.getDrawable(requireContext(), R.drawable.btn_yellow)
                val drawableDefault =
                    ActivityCompat.getDrawable(requireContext(), R.drawable.btn_state)
                panel.background = drawableYellow
                delay(1000)
                panel.background = drawableDefault
            }
            requireActivity().runOnUiThread {
                enableButtons()
            }
        }
    }

    private fun loseAnimation() {
        binding.apply {
            score = 0
            tvScore.text = "0"
            disableButtons()
            val drawableLose = ActivityCompat.getDrawable(requireContext(), R.drawable.btn_lose)
            val drawableDefault = ActivityCompat.getDrawable(requireContext(), R.drawable.btn_state)

            lifecycleScope.launch {
                (root as? ViewGroup)?.forEach { view ->
                    if (view is Button) {
                        view.background = drawableLose
                        delay(200)
                        view.background = drawableDefault
                    }
                }

                delay(1000)
                startGame()
            }
        }
    }





    private fun enableButtons() {
        val rootView = binding.root

        if (rootView is ViewGroup) {
            for (i in 0 until rootView.childCount) {
                val view = rootView.getChildAt(i)
                if (view is Button) {
                    view.isEnabled = true
                }
            }
        }
    }

    private fun disableButtons() {
        val rootView = binding.root

        if (rootView is ViewGroup) {
            for (i in 0 until rootView.childCount) {
                val view = rootView.getChildAt(i)
                if (view is Button) {
                    view.isEnabled = false
                }
            }
        }
    }





    override fun onClick(view: View?) {
        view?.let {
            userAnswer += when (it.id) {
                R.id.panel1 -> "1"
                R.id.panel2 -> "2"
                R.id.panel3 -> "3"
                R.id.panel4 -> "4"
                else -> ""
            }

            if (userAnswer == result) {
                Toast.makeText(requireContext(), "W I N :)", Toast.LENGTH_SHORT).show()
                score++
                binding.tvScore.text = score.toString()
                startGame()
            } else if (userAnswer.length >= result.length) {
                loseAnimation()
            }
        }
    }
}
