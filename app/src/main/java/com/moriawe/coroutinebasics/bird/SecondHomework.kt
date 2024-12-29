package com.moriawe.coroutinebasics.bird

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class SecondHomework : ViewModel(), BirdWindowInterface {

    override fun onClickBirdIcon(bird: Bird) {
        viewModelScope.launch(CoroutineName(bird.name)) {
            while(isActive) {
                println("${coroutineContext[CoroutineName]}: ${bird.sound}")
                delay(bird.soundDelay)
            }
        }
    }

    override fun closeWindow() {

    }

}