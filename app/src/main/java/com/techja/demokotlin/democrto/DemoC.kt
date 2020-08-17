package com.techja.demokotlin.democrto

import kotlinx.coroutines.*


var job=  Job()
var myScope = CoroutineScope(Dispatchers.IO + job)

fun main() = runBlocking {
    myScope.launch {
        println("${Thread.currentThread()}")
        println("-1")

        launch {
            println("${Thread.currentThread()} scope 1")
            println("0")
            delay(500)
            val startTime = System.currentTimeMillis()
            while (System.currentTimeMillis() - startTime <= 1000) {

            }
            println("${Thread.currentThread()} scope 1")
            println("1")
            delay(500)
            println("${Thread.currentThread()} scope 1")
            println("2")
        }

        launch {
            println("${Thread.currentThread()} scope 2")
            println("3")
            delay(600)
            println("${Thread.currentThread()} scope 2")
            println("4")
        }

        println("${Thread.currentThread()}")
        println("5")
    }

    delay(2500)
}