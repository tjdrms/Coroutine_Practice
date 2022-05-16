import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("jon: I'm sleeping $i...")
            delay(500L) //suspend fun이 있어 cancel()에 협조적
        }
    }

    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancel()
    job.join()
    println("main: Now i can quit.")
}