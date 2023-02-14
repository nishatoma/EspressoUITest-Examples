package com.codingwithmitch.espressouitestexamples.coroutines

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class SimpleTest {

    @Test
    fun myFirstTest() {
        // How to test the suspend function? Run blocking!!!
        runBlocking {
            mySuspendFunc()
        }
        Assert.assertEquals(10, 5+5)
    }
}