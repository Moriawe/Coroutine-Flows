@file:OptIn(ExperimentalStdlibApi::class)

package com.moriawe.coroutinebasics

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

@OptIn(ExperimentalStdlibApi::class)
suspend fun queryDatabase() {
    val job = coroutineContext[Job]
    val name = coroutineContext[CoroutineName]
    val handler = coroutineContext[CoroutineExceptionHandler]
    val dispatcher = coroutineContext[CoroutineDispatcher]

    // Supervisor job will not me automatically canceled when one of its children fails
    CoroutineScope(Dispatchers.Main + SupervisorJob()).launch {
        println("Dispatcher: ${coroutineContext[CoroutineDispatcher]}")
        println("Name: ${coroutineContext[CoroutineName]}")
    }

    //
    CoroutineScope(Dispatchers.Main + CoroutineName("Network fetching")).launch {
        launch {
            launch(Dispatchers.Default) {  }
        }
    }
//
//    println("Job: $job")
//    println("Name: $name")
//    println("Handler: $handler")
//    println("Dispatcher: $dispatcher")
}


