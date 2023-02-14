package com.codingwithmitch.espressouitestexamples.coroutines

import kotlinx.coroutines.*

fun main() =
    // We need to then manually make the app wait for our coroutine!
    // Blocks the current main thread
    // In the real world, we don't know how long this will
    // take delay and use runBlocking to run it
    runBlocking {
        println("Main starts: ${Thread.currentThread().name}") // main thread

        // Because we didn't specify GlobalScope, launch scope was within
        // the runBlockin Scope!!
        val job: Job = launch { //Thread t1
            println("fake work: ${Thread.currentThread().name}")
//        Thread.sleep(1000)
            // It is then better to use delay function
            // Coroutine will be suspended in this case for 1 sec
            mySuspendFunc(1000)
            // When resumed, this println might be on another thread
            println("fake work finished: ${Thread.currentThread().name}") // either T1 or some other
        }

        // With the job object, we can control the coroutine
        // RunBlocking creates a coroutine that blocks the main thread
        //mySuspendFunc(2000)
        // We can also cancel with job.cancel()
        // So instead of waiting for 2 seconds, we can use job.join()
        job.join()

        println("Main ends: ${Thread.currentThread().name}") // main thread
}

suspend fun mySuspendFunc(time: Long) {
    // code
    delay(time)
}