import kotlinx.coroutines.*

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i<5) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                //delay(1L) suspend fun 이 없을 시 코루틴이 Exception을 잡아내는데에 비협조적이 되어 cancel 실행이 안됌
                yield() //cancel Exception을 체크하여 잡아내고 코루틴 종료
                println("job: I'm sleeping ${i++} ... ")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancel Exception을 던져 코루틴을 강제 종료 시키는 원리
    println("main: Now i can quit.")
}