package com.example.braintrain

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.braintrain.databinding.FragmentMathGameBinding
import com.example.braintrain.databinding.DialogResultBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.random.Random

class MathGameFragment : Fragment() {
    private lateinit var binding: FragmentMathGameBinding
    private var isPlayed = false
    private var firstRandomNumber: Int? = null
    private var secondRandomNumber: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_math_game, container, false)

        binding.apply {
            btnStartOrNext.setOnClickListener {
                if (isPlayed) {
                    // Next Question
                    getRandomNumbers()
                    tvScore.text = (tvScore.text.toString().toInt() - 1).toString()
                } else {
                    // Start the Game
                    isPlayed = true
                    btnStartOrNext.text = "Next!"
                    cardQuestion.visibility = View.VISIBLE
                    cardScore.visibility = View.VISIBLE
                    getRandomNumbers()
                    runTimer()
                }
            }

            etAnswer.addTextChangedListener {
                val answer = firstRandomNumber!! + secondRandomNumber!!
                if (!it.isNullOrEmpty() && it.toString().toInt() == answer) {
                    // Answer is true
                    tvScore.text = (tvScore.text.toString().toInt() + 1).toString()
                    etAnswer.setText("")
                    getRandomNumbers()
                }
            }
        }

        return binding.root
    }

    private fun runTimer() {
        lifecycleScope.launch(Dispatchers.IO) {
            (1..29).asFlow().onStart {
                binding.constraintLayout.transitionToEnd()
            }.onCompletion {
                // Game finished. Show dialog to the user
                requireActivity().runOnUiThread {
                    binding.cardQuestion.visibility = View.GONE
                    val dialogBinding = DialogResultBinding.inflate(layoutInflater)
                    val dialog = Dialog(requireContext())
                    dialog.apply {
                        requestWindowFeature(Window.FEATURE_NO_TITLE)
                        setContentView(dialogBinding.root)
                        setCancelable(false)
                        show()
                        window?.setLayout(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        )
                        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    }

                    // Clicks
                    dialogBinding.apply {
                        // Show data in dialog
                        tvDialogScore.text = binding.tvScore.text

                        btnTryAgain.setOnClickListener {
                            dialog.dismiss()
                            binding.apply {
                                btnStartOrNext.text = getString(R.string.start_game)
                                cardQuestion.visibility = View.GONE
                                cardScore.visibility = View.GONE
                                isPlayed = false
                                constraintLayout.setTransition(R.id.start, R.id.end)
                                constraintLayout.transitionToEnd()
                                tvScore.text = "0"
                            }
                        }
                    }
                }
            }.collect { delay(1000) }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getRandomNumbers() {
        firstRandomNumber = Random.nextInt(2, 99)
        secondRandomNumber = Random.nextInt(2, 99)
        binding.tvQuestionNumber.text = "$firstRandomNumber + $secondRandomNumber"
    }
}
