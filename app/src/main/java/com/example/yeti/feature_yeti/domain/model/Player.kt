package com.example.yeti.feature_yeti.domain.model

import com.example.yeti.feature_yeti.presentation.constants.gameConstants
import kotlin.math.max
import kotlin.math.min

data class Player(
    var x: Float = 300f,
    var y: Float = 0f,
    var direction: Direction = Direction.DOWN,
    var velocity: Vector = Vector.ZERO,
    var acceleration: Vector = Vector(0f, 10f),
) {
    fun updateAfter(secs: Float) {
        x += velocity.x * secs
        y += velocity.y * secs
        velocity.x = max(
            -gameConstants.MAX_X_VELOCITY,
            min(
                gameConstants.MAX_X_VELOCITY,
                (velocity.x + (acceleration.x * secs))
            )
        )
        velocity.y = max(
            0f,
            min(
                gameConstants.MAX_Y_VELOCITY,
                (velocity.y + (acceleration.y * secs))
            )
        )
        when (direction) {
            Direction.DOWN -> {
                acceleration = gameConstants.DOWN_ACCELERATION
            }
            Direction.LEFT -> {
                acceleration = gameConstants.LEFT_ACCELERATION
            }
            Direction.RIGHT -> {
                acceleration = gameConstants.RIGHT_ACCELERATION
            }
        }


    }
}



