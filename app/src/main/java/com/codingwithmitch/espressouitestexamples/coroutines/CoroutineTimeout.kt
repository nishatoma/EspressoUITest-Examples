package com.codingwithmitch.espressouitestexamples.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    // withTimeout
    val result = withTimeoutOrNull(1000) {
        for (i in 0..500) {
            println("$i.")
            delay(500)
        }
        "I am done"
    }
    println(result)
    println("Second message, program ends.")
}