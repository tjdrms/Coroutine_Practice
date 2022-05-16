import kotlinx.coroutines.*

fun main() = runBlocking {
    val result = withTimeoutOrNull(1300L) { //exception이 발생했을 때, null값을 반환
        repeat(1000) { i ->
            println("I'm sleeping $i..")
            delay(500L)
        }
        "Done"
    }
    println("Result is $result")
}