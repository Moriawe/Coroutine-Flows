package com.moriawe.coroutinebasics.bird

import kotlinx.coroutines.*

fun solutionOne() = runBlocking {
    // Bird 1: Coo every 1 second
    val bird1 = GlobalScope.launch {
        repeat(4) {
            println("Coo")
            delay(1000L) // 1 second delay
        }
    }

    // Bird 2: Caw every 2 seconds
    val bird2 = GlobalScope.launch {
        repeat(4) {
            println("Caw")
            delay(2000L) // 2 second delay
        }
    }

    // Bird 3: Chirp every 3 seconds
    val bird3 = GlobalScope.launch {
        repeat(4) {
            println("Chirp")
            delay(3000L) // 3 second delay
        }
    }

    // Wait for all coroutines to complete
    bird1.join()
    bird2.join()
    bird3.join()
}

fun solutionTwo() = runBlocking {
    // Create a CoroutineScope
    val birdScope = CoroutineScope(Dispatchers.Default)

    // Launch Bird 1: Coo every 1 second
    val bird1 = birdScope.launch {
        while (isActive) {
            println("Coo")
            delay(1000L)
        }
    }

    // Launch Bird 2: Caw every 2 seconds
    val bird2 = birdScope.launch {
        while (isActive) {
            println("Caw")
            delay(2000L)
        }
    }

    // Launch Bird 3: Chirp every 3 seconds
    val bird3 = birdScope.launch {
        while (isActive) {
            println("Chirp")
            delay(3000L)
        }
    }

    // Cancel all bird sounds after 10 seconds
    delay(10000L)
    println("Closing the window, stopping all bird sounds.")
    birdScope.cancel() // Cancels all coroutines in birdScope
}