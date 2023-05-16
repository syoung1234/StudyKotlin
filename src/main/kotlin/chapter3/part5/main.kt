package chapter3.part5
// 예외 처리
fun main() {
    // 함수는 정상 종료, 즉 어떤 값을 반환하거나 비정상적으로 오류가 발생한 경우 예외를 던질 수 있다.
    // try/catch/finally 자바와 같음
}

fun readInt(default: Int): Int {
    try {
        return readLine()!!.toInt()
    } catch (e: NumberFormatException) {
        return default
    } catch (e: Exception) {
        return 0
    }
    // catch 작성 순서대로 예외 타입 검사한다. 그러므로 하위 타입을 먼저 작성해야 한다. 그렇지 않으면 상위 타입에서 모두 catch
}

// 코틀린에서는 try가 식이 될 수 있다.
// 예외가 발생하지 않을 경우 try 블록의 값이 식의 값
// 예외가 발생할 경우 catch 블록의 값이 식의 값
fun readInt2(default: Int) = try {
    readLine()!!.toInt()
} catch (e: NumberFormatException) {
    default
} finally {
    println("Error")
}