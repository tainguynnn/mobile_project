package com.example.braintrain.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import com.example.braintrain.MemoryGame2.MemoryCard
import com.example.braintrain.R


class MemoryGame2Fragment : Fragment() {

    private lateinit var buttons: List<ImageButton>
    private lateinit var cards: List<MemoryCard>
    private var indexOfSingleSelectedCard: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_memory_game2, container, false)

        val images = mutableListOf(
            R.drawable.ic_heart, R.drawable.ic_light, R.drawable.ic_plane, R.drawable.ic_smiley
        )
        // Add each image twice so we can create pairs
        images.addAll(images)
        // Randomize the order of images
        images.shuffle()

        buttons = listOf(
            view.findViewById(R.id.imageButton1), view.findViewById(R.id.imageButton2),
            view.findViewById(R.id.imageButton3), view.findViewById(R.id.imageButton4),
            view.findViewById(R.id.imageButton5), view.findViewById(R.id.imageButton6),
            view.findViewById(R.id.imageButton7), view.findViewById(R.id.imageButton8)
        )

        cards = buttons.indices.map { index ->
            MemoryCard(images[index])
        }

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                Log.i(TAG, "button clicked!!")
                // Update models
                updateModels(index)
                // Update the UI for the game
                updateViews()
            }
        }

        return view
    }

    private fun updateViews() {
        cards.forEachIndexed { index, card ->
            val button = buttons[index]
            if (card.isMatched) {
                button.alpha = 0.1f
            }
            button.setImageResource(if (card.isFaceUp) card.identifier else R.drawable.ic_code)
        }
    }

    private fun updateModels(position: Int) {
        val card = cards[position]
        // Error checking:
        if (card.isFaceUp) {
            Toast.makeText(requireContext(), "Invalid move!", Toast.LENGTH_SHORT).show()
            return
        }
        // Three cases
        // 0 cards previously flipped over => restore cards + flip over the selected card
        // 1 card previously flipped over => flip over the selected card + check if the images match
        // 2 cards previously flipped over => restore cards + flip over the selected card
        if (indexOfSingleSelectedCard == null) {
            // 0 or 2 selected cards previously
            restoreCards()
            indexOfSingleSelectedCard = position
        } else {
            // exactly 1 card was selected previously
            checkForMatch(indexOfSingleSelectedCard!!, position)
            indexOfSingleSelectedCard = null
        }
        card.isFaceUp = !card.isFaceUp
    }

    private fun restoreCards() {
        for (card in cards) {
            if (!card.isMatched) {
                card.isFaceUp = false
            }
        }
    }

    private fun checkForMatch(position1: Int, position2: Int) {
        if (cards[position1].identifier == cards[position2].identifier) {
            Toast.makeText(requireContext(), "Match found!!", Toast.LENGTH_SHORT).show()
            cards[position1].isMatched = true
            cards[position2].isMatched = true
        }
    }
}
