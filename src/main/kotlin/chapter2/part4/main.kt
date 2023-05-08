package chapter2.part4
// 배열
fun main() {
    val a = emptyArray<String>()        // Array<String>
    val b = arrayOf("hello", "world")   // Array<String>
    val c = arrayOf(1, 4, 9)            // Array<Int>

    val size = readLine()!!.toInt()
    val squares = Array(size) { (it + 1) * (it + 1) }

    val operations = charArrayOf('+', '-', '*', '/', '%')
    val squares1 = IntArray(10) { (it + 1) * (it + 1) }

    // 자바와 달리 new 연산자 없음

    squares.size        // 4
    squares.lastIndex   // 2
    squares[1]          // 4

    squares[2] = 100 // 1, 4, 100
    squares[1] += 9  // 1, 13, 100
    squares[0]--     // 0, 13, 100

    val numbers = squares
    numbers[0] = 1000   // 바뀐 데이터가 squares와 numbers에 공유됨
    println(squares[0]) // 1000

    // 원본과 별도로 배열을 만들고 싶다면 copyOf() 함수 사용
    val numbersCopy = squares.copyOf()
    numbersCopy[0] = 100 // squares에 영향을 주지 않음
    squares.copyOf(2) // 1000, 13
    squares.copyOf(4) // 1000, 13, 100, 0, 0 부족한 부분은 0으로 채워짐

    // + 연산을 사용해 원소를 추가할 수 있다.
    val d = intArrayOf(1, 2, 3) + 4 // 1, 2, 3, 4
    val e = intArrayOf(1, 2, 3) + intArrayOf(4, 5, 6) // 1, 2, 3, 4, 5, 6

    // 배열 내용을 비교할 때 contentEquals() 함수 사용
    println(intArrayOf(1, 2, 3).contentEquals(intArrayOf(1, 2, 3))) // true

}