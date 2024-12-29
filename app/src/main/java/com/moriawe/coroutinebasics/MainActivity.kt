package com.moriawe.coroutinebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.moriawe.coroutinebasics.bird.BirdWindowScreen
import com.moriawe.coroutinebasics.bird.FirstHomework
import com.moriawe.coroutinebasics.bird.SecondHomework
import com.moriawe.coroutinebasics.ui.theme.CoroutineBasicsTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity() : ComponentActivity() {

    private val viewModel: SecondHomework by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //ioDefaultDispatcher()

        setContent {
            CoroutineBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BirdWindowScreen(viewModel, Modifier.padding(innerPadding))

                }
            }
        }
    }
}

