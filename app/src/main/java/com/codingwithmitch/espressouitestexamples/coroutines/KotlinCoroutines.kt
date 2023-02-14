package com.codingwithmitch.espressouitestexamples.coroutines

import kotlinx.coroutines.*

fun main() =
    // We need to then manually make the app wait for our coroutine!
    // Blocks the current main thread
    // In the real world, we don't know how long this will
    // take delay and use runBlocking to run it
    runBlocking {
        println("Main starts: ${Thread.currentThread().name}") // main thread

        // worker coroutine
        // output didn't print?
        // When a coroutine is launched, the application
        // does not know if it needs to wait for the coroutine to finish!
        GlobalScope.launch { //Thread t1
            println("fake work: ${Thread.currentThread().name}")
//        Thread.sleep(1000)
            // It is then better to use delay function
            // Coroutine will be suspended in this case for 1 sec
            mySuspendFunc(1000)
            // When resumed, this println might be on another thread
            println("fake work finished: ${Thread.currentThread().name}") // either T1 or some other
        }
        // RunBlocking creates a coroutine that blocks the main thread
        mySuspendFunc(2000)
        println("Main ends: ${Thread.currentThread().name}") // main thread
}

suspend fun mySuspendFunc(time: Long) {
    // code
    delay(time)
}