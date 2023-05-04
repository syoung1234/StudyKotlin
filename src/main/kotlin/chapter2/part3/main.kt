package chapter2.part3

import java.util.Date

// 문자열
fun main() {
    /******* 1. 문자열 템플릿(String Template) *******/
    // " 큰 따옴표로 문자열을 감싼다.
    val hello = "Hello, world!"
    val text = "Hello,world! \n This \" multiline\" string"
    println("\u03C0 \u2248 3.14")

    val name = readLine()
    println("Hello, $name!\nToday is ${Date()}")

    // raw string(로우 문자열)
    val message = """
        Hello, $name!
        Today is ${Date()}
    """.trimIndent() // 들여쓰기를 제거
    println(message)

    /******* 2. 기본 문자열 연산 *******/
    println("Hello!".length) // 6
    println("Hello!".lastIndex) // 5

    val s = "Hello!"
    println(s[0])
    println(s[5])

    val s1 = "Hello!"
    val s2 = "Hel" + "lo!"
    println(s1 == s2) // true
    // 자바에서는 equals()를 사용하지만 코틀린에서는 ==(편의 문법) 사용하여 비교한다.
    // 자바는 참조 동등성을 비교, 코틀린에서 참조 동등성을 쓰고 싶으면 ===, !== 사용

}