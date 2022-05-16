import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        myWorld()
    }

    println("Hello,")
}

suspend fun myWorld() {
    delay(3000L)
    println("World!")
}