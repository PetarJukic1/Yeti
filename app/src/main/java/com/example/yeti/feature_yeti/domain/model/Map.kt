package com.example.yeti.feature_yeti.domain.model

import kotlin.random.Random

data class Map(
    var width: Float,
    var height: Float,
    var obstacles: List<Obstacle>
){
    companion object{
        fun mock(): Map{
            val obstacles: MutableList<Obstacle> = mutableListOf<Obstacle>()
            repeat(200){
                obstacles.add(Obstacle(
                    x = Random.nextInt(0,1000).toFloat(),
                    y = Random.nextInt(0,10000).toFloat()
                ))
            }

            return Map(
                obstacles = obstacles,
                width = 1000f,
                height = 10000f
            )
        }
    }
}