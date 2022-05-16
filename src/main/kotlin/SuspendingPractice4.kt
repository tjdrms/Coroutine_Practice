import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// structured concurrency (중요)
// async함수를 독립적으로 시행하게되면 코루틴 내부에서 발생하는 예외처리가 실행되지 않는 문제점 발생
// async함수도 suspend fun으로 묶어서 코루틴 내부에서만 실행되게 하면 안정성 면에서 훨씬 좋은 코드가 된다!

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        println("The answer is ${concurrentSum()}")
    }
    println("Completed in $time ms")
}

suspend fun concurrentSum(): Int = coroutineScope {
    val one = async { doOne() }
    val two = async { doTwo() }
    one.await() + two.await()
}

suspend fun doOne(): Int {
    delay(1000L)
    return 13
}

suspend fun doTwo(): Int {
    delay(1000L)
    return 29
}

