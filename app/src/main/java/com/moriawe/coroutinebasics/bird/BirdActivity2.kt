package com.moriawe.coroutinebasics.bird

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BirdActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fun CoroutineScope.birdSound(sound: String, interval: Long) = launch {
            repeat(4) {
                Log.i("birdSongs easy", sound) // or println
                delay(interval)
            }
        }
        lifecycleScope.launch {
            birdSound("Coo", 1000L)
            birdSound("Caw", 2000L)
            birdSound("Chirp", 3000L)
        }
    }
}