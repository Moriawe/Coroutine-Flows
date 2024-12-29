package com.moriawe.coroutinebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CancellationActivity: ComponentActivity() {

    val customScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // In this coroutine the job is cancelled before it is finished
        lifecycleScope.launch {
            val job = launch {
                delay(2000L)
                println("Coroutine 2 finished")
            }
            delay(1000L)
            job.cancel()
            println("Coroutine cancelled!")
        }

        // Here the customScope will be cancelled before it finishes.
        // Also, since it is cancelled we can't use anymore to launch coroutines in.
        customScope.launch {
            delay(2000L)
            println("CustomScope coroutine finished")
        }
        lifecycleScope.launch {
            delay(1000L)
            customScope.cancel()
            customScope.launch {
                print("Hello from custom scope")
            }
        }

        // If you want to use that scope again you do like this instead
        lifecycleScope.launch {
            delay(1000L)
            customScope.coroutineContext.cancelChildren()
            customScope.launch {
                print("Hello from custom scope")
            }
        }

    }

    fun hierarky() {
        // In this the inner job 1 will be cancelled but inner job 2 will finish.
        // Cancellations doesn't affect siblings.
        lifecycleScope.launch {
            val job = launch {
                val innerJob1 = launch {
                    delay(2000L)
                    println("Inner job1 finished")
                }
                val innerJob2 = launch {
                    delay(2000L)
                    println("Inner job2 finished")
                }
                delay(1000L)
                innerJob1.cancel()
                println("Inner job 1 cancelled!")
            }
        }

        // In this the parent job is cancelled meaning none of the children will also be cancelled.
        lifecycleScope.launch {
            val job = launch {
                val innerJob1 = launch {
                    delay(2000L)
                    println("Inner job1 finished")
                }
                val innerJob2 = launch {
                    delay(2000L)
                    println("Inner job2 finished")
                }
            }
            delay(1000L)
            job.cancel()
            println("Job cancelled!")
        }
    }

}