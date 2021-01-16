package com.junodev.assignmentapp.ui.tiles.view

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.junodev.assignmentapp.R

class TileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tileNumber: TextView = itemView.findViewById(R.id.tile_number_text_view)
    private val tileCard: MaterialCardView = itemView.findViewById(R.id.tile_card_view)

    fun onBind(number: Int, isDefaultBackground: Boolean) {
        tileNumber.text = number.toString()
        tileCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context,
            if (isDefaultBackground) R.color.gallery else R.color.pear))
    }
}