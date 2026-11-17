package ru.school226.magicwoods.ui.map

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.school226.magicwoods.model.Game

data class MapState(
    val x: Int = 0,
    val y: Int = 0
)

class MapViewModel : ViewModel() {
    private val _state = MutableStateFlow(MapState())
    val state = _state.asStateFlow()

    private val game = Game()

    fun move(dx: Int, dy: Int) {
        game.move(dx, dy)
        _state.value = _state.value.copy(
            x = game.player.x,
            y = game.player.y
        )
    }
}