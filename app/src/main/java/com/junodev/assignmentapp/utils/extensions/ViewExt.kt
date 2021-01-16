package com.junodev.assignmentapp.utils.extensions

import android.view.View
import com.junodev.assignmentapp.utils.DebounceOnClickListener

fun View.setDebounceOnClickListener(interval: Long, listenerBlock: (View) -> Unit) =
    setOnClickListener(DebounceOnClickListener(interval, listenerBlock))