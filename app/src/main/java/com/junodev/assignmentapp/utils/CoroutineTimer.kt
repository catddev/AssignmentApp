package com.junodev.assignmentapp.utils

import kotlinx.coroutines.delay

suspend fun startCoroutineTimer(
    repeatMills: Long = 0,
    action: () -> Unit
) {
    while (true) {
        delay(repeatMills)
        action()
    }
}
