package com.moriawe.coroutinebasics.bird

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Challenge 1-3
class FirstHomework : ViewModel(), BirdWindowInterface {

    private var birdSongJob: Job? = null

    override fun onClickBirdIcon(bird: Bird) {
        birdSongJob?.cancel()
        birdSongJob = viewModelScope.launch {
            while (true) {
                println(bird.sound)
                delay(bird.soundDelay)
            }
        }
    }

    override fun closeWindow() {
        birdSongJob?.cancel()
    }


    private var birdSongJob1: Job? = null
    private var birdSongJob2: Job? = null
    private var birdSongJob3: Job? = null

    fun onBirdIcon1Clicked() {
        birdSongJob1 = viewModelScope.launch {
            // Runs concurrently as the Coo (it's own coroutine)
            val cuckooJob1 = launch {
                repeat(20) {
                    println("Cuu")
                    delay(1000L)
                }
            }
            // Runs concurrently as the Cuu (it's own coroutine)
            val cuckooJob2 = launch {
                repeat(20) {
                    println("Coo")
                    delay(1000L)
                }
            }
        }
    }

    fun onBirdIcon2Clicked() {
        birdSongJob2 = viewModelScope.launch {
            // This one goes first
            repeat(20) {
                println("Caw")
                delay(2000L)
            }
            // This one starts when the first one is ready
            repeat(20) {
                println("Craaw")
                delay(2000L)
            }
        }
    }

    fun onBirdIcon3Clicked() {
        birdSongJob3 = viewModelScope.launch {
            repeat(20) {
                println("Chirp")
                delay(3000L)
            }
        }
    }
}