import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async {doSomethingUseful1()}
        val two = async {doSomethingUseful2()}
        println("The answer is ${one.await()+two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUseful1(): Int {
    println("doSomethingUsefulOne")
    delay(1000L)
    return 13
}

suspend fun doSomethingUseful2(): Int {
    println("doSomethingUsefulTwo")
    delay(1000L)
    return 29
}