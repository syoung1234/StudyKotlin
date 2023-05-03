package chapter2.part1
/**
 * 기본 문법
 **/
fun main() {
    /******* 1. 변수(variable) 정의하기 *******/
    val time = 15 // 세미콜론 생략
    val a = readLine()!!.toInt()
    // readLine(): 표준 입력에서 한 줄을 읽어서 문자열로 반환해주는 표준 코틀린 함수
    // !!는 널 아님 단언(not-null assertion), null일 경우 예외를 발생시킨다.
    // toInt(): 코틀린 String 클래스가 제공하는 method, 문자열을 정수값으로 변환한다.

    // 타입값은 명시하려면?
    val n: Int = 100
    val text: String = "Hello"

    /******* 2. 식별자(identifier) *******/
    // 문자, 숫자, _ 만 포험한다. 숫자로 시작할 수 없다.
    // 하드 키워드를 식별자로 쓸 수 없다.

    // 자바와 달리 코틀린 식별자에는 $를 쓸 수 없다.
    // `` 사이에 빈 문자열을 제외한 아무 문자열이나 와도 된다.
    val `fun` = 1
    val `name with spaces` = 2


    /******* 3. 가변(mutable) 변수 *******/
    // 위에는 불변(immutable) 변수, 불변 변수는 한 번 초기화하면 다시는 값을 대입할 수 없다. 자바의 final 변수와 비슷하다.
    var sum = 1 // 타입 값은 유지 되므로 String 값을 넣을 수 는 없다.
    sum = sum + 2

    var result = 3
    result *= 10 // result = result * 10

    var b = 1
    println(b++) // 1 출력 된 후, b는 2가 됨
    println(++b) // 3 된 후, 3 출력
    println(--b) // 2 된 후, 2 출력
    println(b--) // 2 출력 된 후, 1이 됨
}