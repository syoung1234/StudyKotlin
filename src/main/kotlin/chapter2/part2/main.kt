package chapter2.part2
/**
 * 기본 타입
 **/
fun main() {
    /******* 1. 정수 타입 *******/
    /*
        이름   | 크기(바이트) | 범위
        Byte  | 1         | -128~127
        Short | 2         | -32768~32767
        Int   | 4         | -2,147,483,648~2,147,483,647
        Long  | 8         | -2^63~2^63-1
     */
    val n = 12345

    // 리터럴이 아주 큰 수를 나타낼 때 _ 유용
    val m = 34_721_189

    val one: Byte = 1
    val tenBillions = 10_000_000_000 // Long 타입 추론
    val hundredLong = 100L // Long 타입 추론

    // 앞에 0b(2진수) 또는 0x(16진수)를 붙여서 리터럴을 작성할 수 있다.
    val bin = 0b10101 // 21
    val hex = 0xF9 // 249
    // 코틀린은 8진수를 지원하지 않는다.
    // 0이 앞에 붙은 수 리터럴 금지 예)val n = 01 // error

    // 각 정수 타입에는 최솟값(MIN_VALUE)과 최댓값(MAX_VALUE)을 포함하는 상수 정의가 들어있다.
    Short.MIN_VALUE // -32768
    Short.MAX_VALUE // 32767
    Int.MAX_VALUE + 1 // -2147483648(정수 overflow)

    /******* 2. 부동소수점 수(floating point number) *******/
    /* 자바와 마찬가지로 코틀린도 IEEE 754 부동소수점 수를 따르는 Float, Double 제공 */
    val pi = 3.14
    val o = 1.0

    // 정수 부분이 비어있는 경우 정수 부분을 0으로 간주한다.
    val quarter = .25 // 0.25
    // val oneError = 1. // Error: Expecting an element

    // 과학적 표기법(scientific notation) 리터럴을 허용한다. (e나 E 뒤에 10을 몇 번 거듭제곱하는지 알려주는 숫자)
    val pi1 = 0.314E1       // 3.14 = 0.314 * 10
    val pi100 = 0.314E3     // 314.0 = 0.314 * 1000
    val piOver100 = 3.14E-1 // 0.0314 - 3.14/100
    val thousand = 1E3      // 1000.0 = 1 * 1000

    // 디폴트 부동소수점 리터럴은 Double 타입이다. f 또는 F를 붙이면 Float 타입이 된다.
    val pif = 3.14f
    val onef = 1f // 소수 부분 생략 가능

    /*
        MIN_VALUE, MAX_VALUE: 각 타입에서 표현할 수 있는 가장 작은 유한값과 가장 큰 유한 값
        NEGATIVE_INFINITY, POSITIVE_INFINITY: 음의 무한대와 양의무한대, 각 타입이 표현할 수 있는 가장 작은 값과 가장 큰 값
        NaN: 0/0의 결과처럼 숫자가 아닌 값을 의미
     */
    println(Float.MIN_VALUE)                // 1.4E-45
    println(Double.MAX_VALUE)               // 1.7976931348623157E308
    println(Double.POSITIVE_INFINITY)       // Infinity
    println(1.0/Double.NEGATIVE_INFINITY)   // -0.0
    println(2 - Double.POSITIVE_INFINITY)   // -Infinity
    println(3 * Float.NaN)                  // NaN


    /******* 3. 산술 연산 *******/
    /*
        +(단항), -(단항), +, -, *, /, %
        floorDiv(), mod()
        ====> 정수 나눗셈 연산자가 항상 0 쪽으로 내림, 나머지 연산의 결과는 항상 피제수와 같은 부호
     */
    // floorDiv(): 정수 나눗셈 연산과 마찬가지로 한 수를 다른 수로 나눈 몫을 계산한다.
    //             몫을 더 작은 정수로 내림
    // mod(): 정수 나머지 연산과 마찬가지로 한 수를 다른 수로 나눈 나머지를 계산한다.
    //        a와 a.floorDiv(b)*b 차이를 반환
    println(7/4)                      // 1
    println(7.floorDiv(4))      // 1

    println(-7/4)                     // -1
    println((-7).floorDiv(4))   // -2

    println(7/-4)                     // -1
    println(7.floorDiv(-4))     // -2

    println(-7/-4)                    // 1
    println((-7).floorDiv(-4))  // 1

    println(7%4)                      // 3
    println(7.mod(4))           // 3

    println(-7%4)                     // -3
    println((-7).mod(4))        // 1

    println(7%-4)                     // 3
    println(7.mod(-4))          // -1

    println(-7%-4)                    // -3
    println((-7).mod(-4))       // -3


    val byte: Byte = 1
    val int = 1
    val long = 1L
    val float = 1.5f
    val double = 1.5
    -byte   // -1: Int
    -int    // -1: Int
    -long   // -1: Long
    -float  // -1.5: Float
    -double // -1.5: Double

    // Double > Float > Long > Int > Short > Byte
    // 대부분의 타입에서 해당 타입이 표현할 수 있는 값의 범위가 더 넓다는 뜻. 항상 그렇지는 않음.
    // 예) Long에서 Float로 변환될 경우, 일부 유효 자리를 잃고 정밀도가 떨어짐

    byte + byte     // 2: Byte
    int + byte      // 2: Int
    int + int       // 2: Int
    int + long      // 2: Long
    long + double   // 2.5: Double
    float + double  // 3.0: Double
    float + int     // 2.5: Float
    long + double   // 2.5: Double

    /******* 4. 비트 연산 *******/
    // 자바와 달리 and, or, xor, inv, shl, shr, ushr 제공

    /******* 5. 문자 타입 Char *******/
    // Char 타입은 유니코드 한 글자를 표현하며 16비트
    val z = 'z' // 작은따옴표(') 사이에 문자를 넣는다.

    // \t: tab, \b: backspace, \n: newline, \r: carriage return, \': single quote, \": double quote, \\: backslash, \$: dollar sign
    val quote = '\''
    val newLine = '\n'

    /*
        1. +/- 연산자를 사용해 문자에 수를 더하거나 뺀다. 더하거나 뺀 수만큼 코드포인트가 이동한 새 문자를 반환한다.
        2. 두 문자로 뺄셈을 하면 두 문자의 코드포인트 간 거리를 얻는다.
        3. 문자를 ++ 또는 --로 증가시키거나 감소시킨다.
     */

    var a = 'a'
    var h = 'h'
    println(a + 5) // a 보다 다섯 번째 뒤에 있는 글자 f
    println(a - 5) // a 보다 다섯 번째 앞에 있는 글자 \
    println(h - a) // a와 h 사이의 거리 7
    println(--h)   // h 앞 글자 g
    println(++a)   // a 뒷 글자 b
    // 자바에서는 문자에 대한 산술 연산 결과가 정수로 변환되지만 코틀린은 결과가 Char로 반환된다.

    /******* 6. 수 변환 *******/
    // toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble(), toChar() 등
    // 자바와 달리 코틀린에서는 범위가 큰 타입이 사용돼야 하는 문맥에 범위가 작은 타입을 쓸 수 없다.
    val q = 100
    // val l: Long = q => error

    /******* 7. 불 타입과 논리 연산 *******/
    val f = false;
    val t = true;
    /*
        - !: 논리 부정
        - or, and, xor: 즉시 계산(eager) 방식의 논리합, 논리곱, 논리배타합
        - ||, &&: 지연 계산(lazy)방식의 논리합, 논리곱

        지연 계산자(||, &&)는 자바의 동일 연산자와 똑같은 의미
        ||의 왼쪽 피연산자가 참이면 오른쪽 피연산자를 계산하지 않는다.
        자바의 &, | = 코틀린의 and, or
     */

    /******* 8. 비교와 동등성 *******/
    // 두 인자가 모두 같은 타입일 때만 ==, != 허용
    val a1 = 1
    val b1 = 2L
    // println(a1 == b1) => error
    println(a1.toLong() == b1)

    // 모든 수 타입의 값은 서로 <, <=, >, >=를 사용해 비교할 수 있다.
   println(1 <= 2L || 3 > 4.5)
}