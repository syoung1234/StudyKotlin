package chapter3.part1
// 함수
import kotlin.math.PI

// 함수: 파라미터를 받아서 자신을 호출한 코드 쪽에 출력값을 리턴할 수 있는 재사용 가능한 코드 블록
fun circleArea(radius: Double) : Double { // 반환 타입 Double
    return PI * radius
}

fun main() {
    /******* 1. 코틀린 함수의 구조 *******/
    print("Enter radius: ")
    val radius = readLine()!!.toDouble()
    println("Circle area: ${circleArea(radius)}")

    val a = intArrayOf(1, 2, 3)
    println(incrementArr(a)) // 2
    println(a.contentToString()) // [2, 2, 3]

    /******* 2. 위치 기반 인자와 이름 붙은 인자 *******/
    val w = readLine()!!.toDouble()
    val h = readLine()!!.toDouble()
    println("Rectangle area: ${rectangleArea(w, h)}") // positional argument (위치 기반 인자)
    rectangleArea(width = w, height = h) // 이름 붙은 인자
    rectangleArea(height = h, width = w) // 이름 붙은 인자, 인자의 순서는 중요하지 않다.

    /******* 3. 오버로딩과 디폴트 값 *******/
    // 주어진 호술 식에 대해 실제 호출할 함수를 결정할 때 컴파일러는 자바 오버로딩 해소(overloading resolution) 규칙과 비슷한 다음 규칙을 따른다.
    /*
        1. 파라미터의 개수와 타입을 기준으로 호출할 수 있는 모든 함수를 찾는다.
        2. 덜 구체적인 함수를 제외시킨다. 규칙 1에서 선택한 후보 목록에서 어떤 함수의 파라미터 타입이 다른 함수의 파라미터 타입의 상위 타입(supertype)인
           경우 이 함수는 다른 함수보다 덜 구체적인 함수다. 덜 구체적인 함수가 모두 제외될 때까지 이 단계를 반복한다.
        3. 후보가 하나로 압축되면 이 함수가 호출할 함수다. 후보가 둘 이상이면 컴파일 오류가 발생한다.
     */

    mul(1, 2) // Int가 Any의 하위 타입이므로 1과 4중에 1을 선택
    mul(1L, 2) // Long, Int 타입을 받을 수 있는 함수는 4번 뿐이므로 4를 선택
    mul("0", 3) // String이 Any의 하위 타입이므로 3과 4중에 3을 선택
    mul("0" as Any, 3) // (Any, Int)를 받을 수 있는 함수는 4번 뿐이므로 4를 선택

    /******* 4. vararg *******/
    // 인자의 개수가 정해지지 않은 함수 arrayOf() => 직접 작성한 함수에서 이 기능을 사용 하려면
    // 파라미터 정의 앞에 vararg 변경자(modifier)를 붙이면 된다.
    printSorted(6, 2, 10, 1) // [1, 2, 6, 10]
    val numbers = intArrayOf(6, 2, 10, 1)
    printSorted(*numbers) // 배열을 복사하는 스프레드 연산자를 이용 [1, 2, 6, 10]
    // printSorted(numbers) => error: passing IntArray instead of Int
    println(numbers.contentToString()) // [6, 2, 10, 1]
    // 얕은(shallow) 복사이므로 배열 내부에 차몾가 들어있는 경우에는 참조가 복사된다.

    val b = intArrayOf(1, 2, 3)
    val c = intArrayOf(4, 5, 6)
    change(b, c)
    println(b.contentToString()) // [100, 2, 3]
    println(c.contentToString()) // [4, 5, 6]

    printSorted(6, 1, *intArrayOf(3, 8), 2) // 6,1,3,8,2 => [1, 2, 3, 6, 8]
    // 다른 요소가 모두 같다면 vararg 파라미터가 있는 함수는 동일한 타입의 파라미터 수가 고정돼 있는 함수보다 덜 구체적인 함수로 간주된다.

    /******* 5. 함수의 영역과 가시성 *******/
    /*
        - 파일에 직접 선언된 최상위 함수
        - 어떤 타입 내부에 선언된 멤버 함수
        - 다른 함수 안에 선언된 지역 함수
     */
    println(readIntPair())

    // 함수 내부에 지역 함수를 정의 할 수 있다.
    fun readInt3() = readLine()!!.toInt()
}

/******* 1. 코틀린 함수의 구조 *******/
fun increment(n: Int) : Int {
    return n+1
    // return n++ => Error: Val cannot be reassigned
    // 코틀린 함수 파라미터는 무조건 불변, 자바 메서드 파라미터는 디톨프가 가변
}

fun incrementArr(a: IntArray) : Int {
    return ++a[0]
}


// 반환 타입은 명시해야한다. 일종의 문서화 역할
// 두 가지 경우에만 반환 타입을 생략할 수 있다. 1) Unit 타입 반환 2) 식이 본문(expression-body)인 함수
fun prompt(name: String) {
    println("***** Hello, $name! *****")
}

fun prompt2(name: String) : Unit { // 위와 같은 함수, Unit = 자바의 void, 생략 가능
    println("***** Hello, $name! *****")

    // 식이 본문인 함수는 명시적인 반환 타입 정의를 쓰지 않아도 될 정도로 간단할 때
    // 블록 구문을 사용해 가독성을 높여주는 편이 더 좋다.
    fun circleArea(radius: Double) : Double = PI*radius*radius
    fun circleArea2(radius: Double) = PI*radius*radius
}


/******* 2. 위치 기반 인자와 이름 붙은 인자 *******/
fun rectangleArea(width: Double, height: Double) : Double {
    return width*height
}

/******* 3. 오버로딩과 디폴트 값 *******/
// 컴파일러가 어떤 함수를 호출해야 할지 구분할 수 있도록 오버로딩한 함수의 파라미터 타입이 모두 달라야 한다.
// 같을 경우 컴파일 오류 발생
fun readInt() = readLine()!!.toInt()
fun readInt(radix: Int) = readLine()!!.toInt(radix)

fun mul(a: Int, b: Int) = a*b               // 1
fun mul(a: Int, b: Int, c: Int) = a*b*c     // 2
fun mul(s: String, n: Int) = s.repeat(n)    // 3
fun mul(o: Any, n: Int) = Array(n) {o}      // 4

/******* 4. vararg *******/
fun printSorted(vararg items: Int) {
    items.sort()
    println(items.contentToString())
}

fun change(vararg items: IntArray) {
    items[0][0] = 100
}

/******* 5. 함수의 영역과 가시성 *******/
// fun readIntPair2() = intArrayOf(readInt3(), readInt3()) => main.kt 내부에 선언 되었기 때문에 사용 불가능