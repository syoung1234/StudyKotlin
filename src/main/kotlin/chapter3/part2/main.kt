package chapter3.part2
// 패키지와 임포트
import java.lang.Math // JDK 클래스

import kotlin.Int.Companion.MIN_VALUE

// alias (별명)을 추가 할 수 있다.
import chapter3.part1.readInt as readInt
import chapter3.part1.readInt as radixReadInt

// 한꺼번에 임포트 하는 경우 * 을 붙인다.
// * 보다는 구체적인 선언을 지정해 임포트하는 디렉터리가 우선순위가 더 높다.
import kotlin.math.*

fun main() {
    // 패키지: 관련 있는 선언을 묶는 방법
    // 맨 앞에 패키지 이름을 지정하면 파일에 있는 모든 최상위 선언을 지정한 패키지 내부에 넣을 수 있다.
    // 패키지를 지정하지 않으면 컴파일러는 파일이 디폴트 최상위 패키지에 속한다고 가정한다.
    // 점(.)으로 구별
}

fun fromMin(steps: Int) = MIN_VALUE