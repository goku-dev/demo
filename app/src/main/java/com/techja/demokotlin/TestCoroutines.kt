package com.techja.demokotlin

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


fun main() {
    GlobalScope.launch {
        var time = measureTimeMillis {
            var a: Deferred<Int> = async { demoCodeSuspend1() }
            var b: Deferred<Int> = async { demoCodeSuspend2() }


            println("this is sum =${a.await() + b.await()}")

        }
        println(time)

    }
//    Thread.sleep(1200)
}


suspend fun demoCodeSuspend1(): Int {
    delay(1000)
    return 10
}

suspend fun demoCodeSuspend2(): Int {
    delay(1000)
    return 20
}

//    class MyCoroutinesScope : CoroutineScope {
//        override val coroutineContext: CoroutineContext
//            get() = Dispatchers.Main
//    }

