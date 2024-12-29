package com.moriawe.coroutinebasics.bird

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

@Composable
fun BirdApp() {
    var selectedBird by remember { mutableStateOf<BirdType?>(null) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { selectedBird = BirdType.COO }) {
            Text("Bird 1 (Coo)")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { selectedBird = BirdType.CAW }) {
            Text("Bird 2 (Caw)")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { selectedBird = BirdType.CHIRP }) {
            Text("Bird 3 (Chirp)")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Display the bird sound and name based on selection
        selectedBird?.let { bird ->
            BirdSound(bird)
        }
    }
}

@Composable
fun BirdSound(bird: BirdType) {
    val coroutineScope = rememberCoroutineScope()

    // Display bird name on screen
    Text(text = bird.birdName)

    // Start the corresponding sound coroutine
    LaunchedEffect(bird) {
        coroutineScope.launch {
            while (isActive) {
                println(bird.sound)
                delay(bird.delay)
            }
        }
    }
}

// Define bird types and properties
enum class BirdType(val birdName: String, val sound: String, val delay: Long) {
    COO("Bird 1: Coo", "Coo", 1000L),
    CAW("Bird 2: Caw", "Caw", 2000L),
    CHIRP("Bird 3: Chirp", "Chirp", 3000L)

}