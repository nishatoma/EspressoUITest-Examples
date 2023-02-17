package com.codingwithmitch.espressouitestexamples.coroutines

import kotlinx.coroutines.*

// The coroutine code has to be cooperative in order to be
// cancelled
fun main() = runBlocking {
    println("The program starts: ${Thread.currentThread().name}")

    val job = launch(Dispatchers.Default) {
        println(Thread.currentThread().name)
        try {
            for (i in 0..100){
                // check active or not
                print("$i.")
                delay(100)
            }
        } catch (e: CancellationException) {
            println("Exception: ${e.message}")
        } finally {
            // Won't make it here without withContext
            withContext(NonCancellable) {
                delay(2000)
                println("Resource closed finally")
            }

        }

    }

    // Delay first
    println("\nattempting to cancel")
    delay(10)
    job.cancelAndJoin()
    println("\nCancelled")
    println("\nMain program ends: ${Thread.currentThread().name}") //main thread
}