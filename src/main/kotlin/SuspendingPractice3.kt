import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) {doSomethingUseful()}
        val two = async(start = CoroutineStart.LAZY) {doSomethingUsefull()}
        one.start()
        two.start()
        println("The answer is ${one.await()+two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUseful(): Int {
    println("doSomethingUsefulOne")
    delay(1000L)
    return 13
}

suspend fun doSomethingUsefull(): Int {
    println("doSomethingUsefulTwo")
    delay(1000L)
    return 29
}