package chapter3.part1

private fun readInt2() = readLine()!!.toInt() // private 으로 정의하면 main.kt에서 쓸 수 없음

fun readIntPair() = intArrayOf(readInt2(), readInt2()) // main.kt에서 사용 가능 (public)

