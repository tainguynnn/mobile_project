package com.example.braintrain.score

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.braintrain.R

class ScoreAdapter(val scoreList:ArrayList<ScoreModel>):
    RecyclerView.Adapter<ScoreAdapter.MyViewHolder>(){
    inner class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
        var scoreImg : ImageView
        var title : TextView
        var score : TextView

        init {
            scoreImg = itemView.findViewById(R.id.cardViewImg)
            title = itemView.findViewById(R.id.title)
            score = itemView.findViewById(R.id.score)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_item,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return scoreList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.scoreImg.setImageResource(scoreList[position].img)
        holder.title.setText(scoreList[position].title)
        holder.score.setText(scoreList[position].score.toString())
    }
}