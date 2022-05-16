import kotlinx.coroutines.*

fun main() = runBlocking {
    withTimeout(1300L) { // launch애서 실행하지 않았고 별다른 반환값이 없어서 exception을 일으킴
        repeat(1000) { i ->
            println("I'm sleeping $i..")
            delay(500L)
        }
    }
}