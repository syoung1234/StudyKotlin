package chapter3.part3
// 조건문
fun main(args: Array<String>) {
    /******* 1. if 문으로 선택하기 *******/
    // 자바: if, switch
    // 코틀린: if, when
    if (args.isNotEmpty()) {
        val message = "Hello, ${args[0]}"
        println(message)
    } else {
        println()
    }
    // 코틀린은 if를 식으로 사용할 수 있다.
    fun max2(a: Int, b: Int) = if (a > b) a else b

    val s = readLine()!!
    val i  = s.indexOf("/")

    val result = if (i>=0) {
        val a = s.substring(0, i).toInt()
        val b = s.substring(i + 1).toInt()
        (a/b).toString()
    } else ""
    println(result)
    // 식으로 사용할 때는 else 필수
    // 코틀린은 자바와 달리 3항 연산자 (조건 ? 참 : 거짓)가 없다. 하지만 if를 식으로 쓸 수 있다.

    println(renamePackage("foo.bar.old", "new")) // foo.bar.new

    /******* 2. 범위, 진행, 연산 *******/
    // range (범위): 순서가 정해진 값 사이의 수열(interval)을 표현하는 타입
    // .. 연산자 (시작 값과 끝 값이 범위에 포함)
    val chars = 'a'..'h' // 'a'부터 'h'까지의 모든 문자
    val twoDigits = 10..99 // 10부터 99까지 모든 수
    val zero2One = 0.0..1.0 // 0부터 1까지의 모든 부동소수 점

    // in, !in 연산자: 어떤 값이 범위 안에 들어있는지
    // until: 끝 값을 포함하지 않음
    // downTo: 아래로 내려가는 진행
    val num = readLine()!!.toInt()
    println(num in 10..99) // num >= 10 && num <= 99
    println(num !in 10..99) // !(num in 10..99)
    println("def" in "abc".."xyz") // true
    println("zzz" in "abc".."xyz") // false

    val twoDigits2 = 10 until 100 // 10..99와 같음. 100은 포함되지 않음
    println(5 in 5..5) // true
    println(5 in 5 until 5) // false
    println(5 in 10..1) // false, 끝 값이 시작 값보다 더 작으면 빈 범위
    println(5 in 10 downTo 1) // true
    println(5 in 1 downTo 10) // false, 빈 범위

    // progression (진행): 정해진 step (간격) 만큼 떨어져 있는 정수나 Char 값들로 이뤄진 시퀀스
    // step(간격)을 지정할 수 있다. step은 양수
    println(1..10 step 3) // 1, 4, 7, 10
    println(15 downTo 9 step 2) // 15, 13, 11, 9

    // subString()
    println("Hello, world".substring(1..4)) // ello
    println("Hello, world".substring(1 until 4)) // ell
    println("Hello, world".substring(1, 4)) // ell, until 과 같음
    println(IntArray(10) { it * it }.sliceArray(2..5)) // 4, 9, 16, 25
    println(IntArray(10) { it * it }.sliceArray(2 until 5)) // 4, 9, 16

    /*
        우선 순위
        덧셈(+,-) > 범위(..) > 중위(and, or) > 원소 검사(in, !in) > 비교(<,>,<=,>=)
     */
    // until, downTo, step은 다른 이름 붙은 중위 연산자(and, or 등)와 우선순위가 같다.

    /******* 3. when 문과 여럿 중에 하나 선택하기 *******/

}

/******* 1. if 문으로 선택하기 *******/
fun max(a: Int, b: Int): Int {
    return if (a > b) a
    else b

    // if (a > b) return a
    //    else return b
}

fun renamePackage(fullName: String, newName:String): String {
    val i = fullName.lastIndexOf('.') // 마지막 . 위치
    val prefix = if (i>=0) fullName.substring(0, i+1) else return newName
    return prefix + newName
}

/******* 3. when 문과 여럿 중에 하나 선택하기 *******/
fun hexDigit(n: Int): Char {
    if (n in 0..9) return '0' + n
    else if (n in 10..15) return 'A' + n - 10
    else return '?'
}
// when 으로 변경하여 더 간결하게 만들 수 있다.
fun hexDigit2(n: Int): Char {
    when {
        n in 0..9 -> return '0' + n
        n in 10..15 -> return 'A' + n - 10
        else -> return '?'
    }
}

// when 문도 if 처럼 식으로 쓸 수 있다.
fun hexDigit3(n: Int) = when {
    n in 0..9 -> '0' + n
    n in 10..15 -> 'A' + n - 10
    else -> '?'
}
// 자바 switch 와 코틀린 when 차이
// when에서는 임의의 조건을 검사 할 수 있지만 switch에서는 주어진 식의 여러 가지 갑 중 하나만 선택할 수 있다.
// when은 조건을 만족하는 가지만 실행하고 폴스루를 하지 않는다.

// 한 가지 값을 대상으로 조건 검색을 할 때 더 간결하게 만들 수 있다.
fun numberDescription(n: Int, max: Int = 100): String = when (n) {
    0 -> "Zero"
    1, 2, 3 -> "Small"
    in 4..9 -> "Medium"
    in 10..max -> "Large"
    !in Int.MIN_VALUE until 0 -> "Negative"
    else -> "Huge"
}

// 코틀린 1.3 부터는 변수에 연결할 수 있다. var로 선언할 수는 없다.
fun readHexDigit() = when(val n = readLine()!!.toInt()) { // n을 정의
    in 0..9 -> '0' + n
    in 10..15 -> 'A' + n - 10
    else -> '?'
}