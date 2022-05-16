import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch {
        println("main runBlocking  : I'm working in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.IO) {
        println("IO  : I'm working in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default) {
        println("Default  : I'm working in thread ${Thread.currentThread().name}")
    }

    newSingleThreadContext("MyOwnThread").use {
        launch {
            println("newSingleThreadContext  : I'm working in thread ${Thread.currentThread().name}")
        }

    }
}