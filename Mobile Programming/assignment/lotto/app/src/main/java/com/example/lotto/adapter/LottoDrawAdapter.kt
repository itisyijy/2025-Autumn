package com.example.lotto.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lotto.R
import com.example.lotto.data.LottoDraw

class LottoDrawAdapter(
    private val onDeleteClick: (LottoDraw) -> Unit
) : RecyclerView.Adapter<LottoDrawAdapter.LottoDrawViewHolder>() {

    // data list
    private val draws = mutableListOf<LottoDraw>()

    // load all draw data for initializing
    fun setDraws(newDraws: List<LottoDraw>) {
        draws.clear()
        draws.addAll(newDraws)
        notifyDataSetChanged()
    }

    // add draw item, update part of view based on position
    fun addDraw(draw: LottoDraw, position: Int) {
        draws.add(position, draw)
        notifyItemInserted(position)
    }

    // remove draw item, update part of view based on position
    fun removeDraw(position: Int) {
        draws.removeAt(position)
        notifyItemRemoved(position)
    }

    // generate ViewHolder when new view required
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LottoDrawViewHolder {
        val view = LayoutInflater.from(parent.context) // XML to View
            .inflate(R.layout.item_lotto, parent, false)
        return LottoDrawViewHolder(view)
    }

    // data binding to ViewHolder when view is recycled by scrolling
    override fun onBindViewHolder(holder: LottoDrawViewHolder, position: Int) {
        holder.bind(draws[position])
    }

    // number of items
    override fun getItemCount(): Int = draws.size

    fun getItem(position: Int): LottoDraw = draws[position]

    // inner: able to access external class member
    inner class LottoDrawViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val numbersTextView: TextView = itemView.findViewById(R.id.numbersTextView)
        private val deleteButton: View = itemView.findViewById(R.id.deleteButton)

        // data binding to view
        fun bind(draw: LottoDraw) {
            val sortedNumbers = draw.numbers.sorted()
            numbersTextView.text = sortedNumbers.joinToString("  ")
            
            deleteButton.setOnClickListener {
                onDeleteClick(draw)
            }
        }
    }
}

