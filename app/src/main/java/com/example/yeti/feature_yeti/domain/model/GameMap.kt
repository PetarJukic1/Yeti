package com.example.yeti.feature_yeti.domain.model

data class GameMap(
    val map: Map,
    val player: Player,
    val opponent: Player
){
    companion object{
        fun mock(): GameMap{
            return GameMap(
                map = Map.mock(),
                player = Player(300f,0f,Direction.DOWN, Vector.ZERO,Vector(0f,10f)),
                opponent = Player(700f,0f,Direction.DOWN, Vector.ZERO,Vector(0f,10f))
            )
        }
    }
}