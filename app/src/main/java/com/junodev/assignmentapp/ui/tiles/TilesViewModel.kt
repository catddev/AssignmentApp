package com.junodev.assignmentapp.ui.tiles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junodev.assignmentapp.models.presentation.Tiles
import com.junodev.assignmentapp.utils.extensions.insertAtRandomIndex
import com.junodev.assignmentapp.utils.startCoroutineTimer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.*

class TilesViewModel : ViewModel() {

    private val pool: PriorityQueue<Int> = PriorityQueue()
    private val _tiles = MutableStateFlow(initTiles())
    val tiles: StateFlow<Tiles> = _tiles.asStateFlow()

    init {
        viewModelScope.launch {
            startCoroutineTimer(REPEAT_MILLS) { fetchTiles() }
        }
    }

    fun deleteTile(number: Int) {
        _tiles.value = _tiles.value.deleteTile(number)
        pool.offer(number)
    }

    private fun fetchTiles() {
        _tiles.value = _tiles.value.addTile()
    }

    private fun Tiles.deleteTile(number: Int) = copy(numbers = numbers.filter { it != number })

    private fun Tiles.addTile(): Tiles {
        val number = getNextTileNumber()
        return copy(numbers = numbers.insertAtRandomIndex(number), lastAddedNumber = number)
    }

    private fun getNextTileNumber(): Int = extractFromPool() ?: createNumber()

    private fun extractFromPool(): Int? = pool.poll()

    private fun createNumber(): Int = _tiles.value.numbers.maxOrNull()?.inc() ?: 0

    private fun initTiles() = Tiles(List(INITIAL_TILE_COUNT) { it + 1 })

    companion object {
        private const val INITIAL_TILE_COUNT = 15
        private const val REPEAT_MILLS = 5000L
    }
}
