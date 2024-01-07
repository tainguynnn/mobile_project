package com.example.braintrain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.braintrain.databinding.FragmentScoreBinding


class ScoreFragment : Fragment() {

    private lateinit var binding: FragmentScoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_score, container, false)
        val rootView = binding.root

        val recyclerView: RecyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val scoreList: ArrayList<ScoreModel> = ArrayList()

        val s1 = ScoreModel(R.drawable.math, "Math Game", 20)
        val s2 = ScoreModel(R.drawable.attention, "Attention Game", 20)
        val s3 = ScoreModel(R.drawable.math, "Math Game", 20)
        val s4 = ScoreModel(R.drawable.memory, "Memory Game", 20)
        val s5 = ScoreModel(R.drawable.language, "Language Game", 20)
        val s6 = ScoreModel(R.drawable.memory, "Memory Game", 20)
        val s7 = ScoreModel(R.drawable.attention, "Attention Game", 20)
        val s8 = ScoreModel(R.drawable.language, "Language Game", 20)
        val s9 = ScoreModel(R.drawable.math, "Math Game", 20)

        scoreList.add(s1)
        scoreList.add(s2)
        scoreList.add(s3)
        scoreList.add(s4)
        scoreList.add(s5)
        scoreList.add(s6)
        scoreList.add(s7)
        scoreList.add(s8)
        scoreList.add(s9)

        val adapter = ScoreAdapter(scoreList)
        recyclerView.adapter = adapter

        return rootView
    }
}



