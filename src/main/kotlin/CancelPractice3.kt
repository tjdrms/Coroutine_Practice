import kotlinx.coroutines.*

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) { // isActive는 현 코루틴의 context값을 따져 실행중인지 아닌지를 boolean 값으로 반환
            // context(상태)값을 따지기 때문에 exception을 일으키지 않아도 cancel 함수 실행 가능(suspend fun이 없어도 가능)
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ... ")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() //isActive가 내장되어 있어 exception을 일으키지 않고도 cancel하라는 상태값만 전달하여 작동 -> isActive값이 True -> False
    println("main: Now i can quit.")
}