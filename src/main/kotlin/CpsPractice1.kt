import kotlinx.coroutines.*
//jvm으로 디컴파일 될때, 자바의 swithcase문으로 콜백되어 처리되는 CPS기법을 통해 코루틴이 불리는것 (마법같이 자동으로 비동기 처리 되는것이 아님)
fun main(): Unit {
    GlobalScope.launch {
        val userData = fetchUserData()
        val userCache = cacheUserData(userData)
        updateTextView(userCache)
    }
}

suspend fun fetchUserData() = "user_name"
suspend fun cacheUserData(user: String) = user
fun updateTextView(user: String) = user