package com.example.yeti.feature_yeti.domain.model

data class Map(
    var width: Float,
    var height: Float,
    var obstacles: Array<Obstacle>
)