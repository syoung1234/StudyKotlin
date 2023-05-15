package chapter3.part4
// 루프
import kotlin.random.Random

fun main() {
    /******* 1. while 과 do-while 루프 *******/
    var sum = 0
    var num: Int

    // do-while: 최소 한 번은 실행
    do {
        num = readLine()!!.toInt()
        sum += num
    } while (num != 0)

    println("Sum: $sum")

    val n = Random.nextInt(1, 101)
    var guess = 0

    // while: 처음부터 조건이 거짓이면 루프 몸통이 한 번도 실행되지 않는다.
    while (guess != n) {
        guess = readLine()!!.toInt()
        if (guess < n) println("Too small")
        else if (guess > n) println("Too big")
    }

    println("Right: it's $n")

    /******* 2. for 루프와 이터러블 *******/
    val a = IntArray(10) { it*it } // 0, 1, 4, 9, 16 ~
    var s = 0

    for (x in a) {
        s += x
    }

    for (i in 0..a.lastIndex) {
        if (i % 2 == 0) {
            a[i] *= 2
        }
    }
    println("Sum: $s") // Sum: 285

    /******* 3. 루프 제어 흐름 변경하기 *******/
    // break: 즉시 루프 종료
    // continue: 현재 루프 이터레이션을 마치고 조건 검사 진행
    while (true) {
        val guess = readLine()!!.toInt()

        val message =
            if (guess < n) "Too small"
            else if (guess > n) "Too big"
            else break
        println(message)
    }
    println("Right: it's $n")

    /******* 4. 내포된 루프와 레이블 *******/
    loop@ while (true) {
        val g = readLine()!!.toInt()

        val msg = when {
            g < n -> "Too small"
            g > n -> "Too big"
            else -> break@loop
        }
        println(msg)
    }
    println("Right: it's $n")

}

/******* 2. for 루프와 이터러블 *******/
fun parseIntNumber(s: String, fallback: Int = -1): Int {
    var num = 0
    if (s.length !in  1..31) return fallback

    for (c in s) {
        if (c !in '0'..'1') return fallback
        num = num*2 + (c - '0')
    }
    return num
}

/******* 3. 루프 제어 흐름 변경하기 *******/
fun countLetters(text: String): IntArray {
    val counts = IntArray('z' - 'a' + 1)

    for (char in text) {
        val charLower = char.toLowerCase()
        if (charLower !in 'a'..'z') continue
        counts[charLower - 'a']++
    }
    return counts
}

/******* 4. 내포된 루프와 레이블 *******/
fun indexOf(subarray: IntArray, array: IntArray): Int {
    // continue@outerLoop: 바깥쪽 루프의 현재 이터레이션을 끝내고 다음 이터레이션을 시작
    outerLoop@ for (i in array.indices) {
        for (j in subarray.indices) {
            if (subarray[j] != array[i + j]) continue@outerLoop
        }
        return i
    }
    return -1
}

/******* 5. 꼬리 재귀 함수 (tail recursive) *******/
// tailrec 을 붙이면 컴파일러가 재귀 함수를 비재귀적인 모드로 자동 변환해준다.
// 재귀 함수의 간결함과 비재귀 루프의 성능만 취할 수 있다.
tailrec fun binIndexOf(
    x: Int,
    array: IntArray,
    from: Int = 0,
    to: Int = array.size
): Int {
    if (from == to) return -1
    val midIndex = (from + to -1) / 2
    val mid = array[midIndex]
    return when {
        mid < x -> binIndexOf(x, array, midIndex+1, to)
        mid > x -> binIndexOf(x, array, from, midIndex)
        else -> midIndex
    }
}

// 비재귀함수
fun binIndexOf2(
    x: Int,
    array: IntArray,
    from: Int = 0,
    to: Int = array.size
): Int {
    var fromIndex = from
    var toIndex = to

    while (true) {
        if (fromIndex == toIndex) return -1
        val midIndex = (fromIndex + toIndex -1) / 2
        val mid = array[midIndex]

        when {
            mid < x -> fromIndex = midIndex + 1
            mid > x -> toIndex = midIndex
            else -> return midIndex
        }
    }
}