package uk.me.mungorae.androidweekly.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DispatcherProvider {

    fun io(): CoroutineDispatcher

    fun main(): CoroutineDispatcher

    class Android: DispatcherProvider {
        override fun io() = Dispatchers.IO

        override fun main() = Dispatchers.Main
    }
}