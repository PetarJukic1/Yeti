package com.example.yeti.feature_yeti.domain.model

data class Vector(
    var x: Float,
    var y: Float,
){
    companion object {
        val ZERO = Vector(0f, 0f)
    }
}