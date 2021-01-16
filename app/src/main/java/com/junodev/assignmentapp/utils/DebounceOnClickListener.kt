package com.junodev.assignmentapp.utils

import android.view.View

class DebounceOnClickListener(
    private val interval: Long,
    private val listenerBlock: (View) -> Unit
) : View.OnClickListener {

    private var lastClickTime = 0L

    override fun onClick(view: View) {
        val time = System.currentTimeMillis()
        if (time - lastClickTime > interval) {
            lastClickTime = time
            listenerBlock(view)
        }
    }
}