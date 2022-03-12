package com.example.yeti.feature_yeti.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.yeti.feature_yeti.domain.model.GameMap
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GameViewModel : ViewModel() {

    val latestUpdate: Flow<GameMap> = flow {
        while (true) {
            //gets data from api
            //emits data to api
            delay(25)
        }
    }
    private val _gameMap = mutableStateOf(GameMap.mock())
    var gamemap = _gameMap

    suspend fun startUpdate() {
    }

}