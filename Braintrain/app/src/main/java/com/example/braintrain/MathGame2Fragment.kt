package com.example.braintrain

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.braintrain.databinding.FragmentMathGame2Binding
import java.util.Random


class MathGame2Fragment : Fragment() {

    lateinit var binding: FragmentMathGame2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_math_game2, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLeft.setOnClickListener {
            // code here will run every time the left button is clicked
            checkAnswer(isLeftButtonSelected = true)
            assignNumbersToButtons()
        }

        binding.btnRight.setOnClickListener {
            // 1. Compare the numbers in the boxes
            checkAnswer(isLeftButtonSelected = false)
            // 2. Pick new random numbers
            assignNumbersToButtons()
        }

        assignNumbersToButtons()
    }

    private fun checkAnswer(isLeftButtonSelected: Boolean) {
        val leftNum: Int = binding.btnLeft.text.toString().toInt()
        val rightNum: Int = binding.btnRight.text.toString().toInt()
        val isAnswerCorrect = if (isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum
        if (isAnswerCorrect) {
            // Correct answer!!
            // Change the background color
            binding.backgroundView.setBackgroundColor(Color.CYAN)
            // Show a toast
            Toast.makeText(requireContext(), "CORRECT!!", Toast.LENGTH_SHORT).show()
        } else {
            // Wrong answer!!
            binding.backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(requireContext(), "WRONG!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignNumbersToButtons() {
        val r = Random()
        var leftNum: Int
        var rightNum: Int

        do {
            leftNum = r.nextInt(20)
            rightNum = r.nextInt(20)
        } while (leftNum == rightNum)

        binding.btnLeft.text = leftNum.toString()
        binding.btnRight.text = rightNum.toString()
    }
}
