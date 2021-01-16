package com.junodev.assignmentapp.utils.extensions

import kotlin.random.Random
import kotlin.random.nextInt

fun <T> List<T>.insertAtRandomIndex(element: T): List<T> =
    this.toMutableList().apply { add(Random.nextInt(0..size), element) }