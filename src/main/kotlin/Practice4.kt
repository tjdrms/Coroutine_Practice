import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        repeat(5) { i ->
            println("Coroutine A $i")
            delay(10L)
        }
    }

    launch {
        repeat(5) { i ->
            println("Coroutine B $i")
            delay(10L)
        }
    }

    println("Coroutine Outer")
}