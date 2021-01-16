package com.junodev.assignmentapp.ui.tiles.view

import androidx.recyclerview.widget.DiffUtil

class TilesDiffUtilCallback(
    private val oldList: List<Int>,
    private val newList: List<Int>,
    private val previousChangedItem: Int?
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem && oldItem != previousChangedItem
    }
}
