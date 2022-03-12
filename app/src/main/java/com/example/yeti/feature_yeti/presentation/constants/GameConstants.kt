package com.example.yeti.feature_yeti.presentation.constants

import com.example.yeti.feature_yeti.domain.model.Vector

class GameConstants {
    companion object {
        const val MAX_X_VELOCITY = 20f
        const val MAX_Y_VELOCITY = 50f

        val LEFT_ACCELERATION = Vector(5f, -5f)
        val RIGHT_ACCELERATION = Vector(-5f, -5f)
        val DOWN_ACCELERATION = Vector(0f, 10f)

    }
}