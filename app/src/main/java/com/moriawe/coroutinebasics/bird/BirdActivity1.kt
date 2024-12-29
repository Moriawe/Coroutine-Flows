package com.moriawe.coroutinebasics.bird

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BirdActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            var count = 0

            val bird1Job = launch {
                repeat(4) {
                    delay(1_000)
                    println("Coo")
                }
            }

            val bird2Job = launch {
                repeat(4) {
                    delay(2_000)
                    println("Caw")
                }
            }

            val bird3Job = launch {
                repeat(4) {
                    delay(3_000)
                    println("Chirp")
                }
            }

            launch {
                repeat(4) {
                    delay(1_000)
                    println(count++)
                }
            }
        }

    }
}