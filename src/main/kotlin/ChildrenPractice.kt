import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val request =launch {
        GlobalScope.launch {
            println("1: 나는 main 코루틴의 자식이 아닌 전역 코루틴스코프임")
            delay(1000)
            println("1:나는 globalscope이기때문에 부모자식 관계가 없어서 cancel 안됌ㅋㅋ")
        }

        launch {
            delay(100)
            println("2: 나는 main 코루틴의 자식임")
            delay(1000)
            println("2: 나는 부모 코루틴이 cancel을 하면 자동으로 나도 cancel됌 ㅜㅜ")
        }
    }
    delay(500)
    request.cancel()
    delay(1000)
    println("main: 누가 cancel 작업에서 살아 남을까?")
}