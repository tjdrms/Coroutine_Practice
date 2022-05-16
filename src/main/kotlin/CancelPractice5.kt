import kotlinx.coroutines.* //매우 드문 케이스

fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i...")
                delay(500L)
            }
        } finally {
            withContext(NonCancellable) { //이 부분에서는 NonCancellable상태를 가져오기 때문에 cancel이 되지않음
                println("job: I'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }

    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // try부분에서 cancel, finally부분에서는 join
    println("main: Now i can quit.")
}