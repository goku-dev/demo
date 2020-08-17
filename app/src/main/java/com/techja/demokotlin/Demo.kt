package com.techja.demokotlin

import android.util.Log
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class Demo {
    var TAG = "phi.hd"
    var job=  Job()
    var myScope = CoroutineScope(Dispatchers.Main + job)

    fun start() {

            val deferreds = emptyList<Deferred<Int>>().toMutableList()

            val startTime = System.currentTimeMillis()


            for (i in 0..10) {
                val tmp: Deferred<Int> = myScope.async(Dispatchers.Default) {
                    Log.d(TAG, "$i = ${Thread.currentThread()}")
                    longTimeTask2(i)
                }
                deferreds += tmp
            }

        myScope.launch {
            deferreds.awaitAll().sum()
            Log.d(TAG, "Time load ${System.currentTimeMillis() - startTime} ms")
        }



        Log.d(TAG, "Below launch")
    }

    private suspend fun longTimeTask() : Int = withContext(Dispatchers.Default) {
        val startTime = System.currentTimeMillis()
        while (System.currentTimeMillis() - startTime <= 100) {

        }

        10
    }


    private suspend fun longTimeTask2(input: Int) : Int {
        val startTime = System.currentTimeMillis()
        while (System.currentTimeMillis() - startTime <= 100) {

        }

        return 11 + input
    }

    private fun longTimeTask(callBack: (Int) -> Unit) {
        thread(start = true) {
            val startTime = System.currentTimeMillis()
            while (System.currentTimeMillis() - startTime <= 1000) {

            }

            callBack(10)
        }
    }

    private fun longTimeTask2(input: Int, callBack: (Int) -> Unit) {
        thread(start = true) {
            val startTime = System.currentTimeMillis()
            while (System.currentTimeMillis() - startTime <= 1000) {

            }

            callBack(11 + input)
        }

    }
}