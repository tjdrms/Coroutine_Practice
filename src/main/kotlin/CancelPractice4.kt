import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i...")
                delay(500L)
            }
        } finally {
            //리소스를 해제시키는 구간
            println("job: I'm running finally")
        }
    }

    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now i can quit.")
}