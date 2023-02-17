package com.codingwithmitch.espressouitestexamples.coroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    println("Main starts ${Thread.currentThread().name}")



    // How to execute concurrently? Like so
    val messageOne = async(start = CoroutineStart.LAZY) { getMessageOne() }
    val messageTwo = async(start = CoroutineStart.LAZY) { getMessageTwo() }
//    println("The entire message is: ${messageOne.await() + messageTwo.await()}")

    println("Main program ends ${Thread.currentThread().name}")
}

suspend fun getMessageOne(): String {
    delay(1000L)
    println("After working for getMessageOne()")
    return "Hello "
}

suspend fun getMessageTwo(): String {
    delay(1000L)
    println("After working for getMessageTwo()")
    return "World"
}