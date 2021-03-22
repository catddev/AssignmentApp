package com.junodev.assignmentapp.utils.extensions

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.setupGridLayout(context: Context, spanCount: Int) {
    layoutManager = GridLayoutManager(context, spanCount)
}
