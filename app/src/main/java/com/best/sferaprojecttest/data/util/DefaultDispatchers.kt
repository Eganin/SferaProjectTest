package com.best.sferaprojecttest.data.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DefaultDispatchers {

    fun io(): CoroutineDispatcher

    fun default(): CoroutineDispatcher

    fun main(): CoroutineDispatcher

    class Base : DefaultDispatchers {
        override fun io() = Dispatchers.IO

        override fun default() = Dispatchers.Default

        override fun main() = Dispatchers.Main
    }
}