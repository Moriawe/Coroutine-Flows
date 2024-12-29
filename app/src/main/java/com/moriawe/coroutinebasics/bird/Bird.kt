package com.moriawe.coroutinebasics.bird

import androidx.compose.ui.graphics.Color

data class Bird(
    val name: String,
    val sound: String,
    val soundDelay: Long,
    val color: Color
)

val listOfBirds = listOf(
    Bird("Cuucko", "Coo", 1000L, Color.Red),
    Bird("Crow", "Caw", 2000L, Color.Green),
    Bird("Bluebird", "Chirp", 3000L, Color.Cyan)
)
