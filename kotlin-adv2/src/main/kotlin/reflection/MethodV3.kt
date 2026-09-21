package hello.reflection

import hello.reflection.data.Calculator
import java.util.Scanner
import kotlin.reflect.full.declaredFunctions

fun main() {
    val scanner = Scanner(System.`in`)
    print("호출 메서드: ")
    val methodName = scanner.nextLine()

    print("숫자 1: ")
    val num1 = scanner.nextInt()
    print("숫자 2: ")
    val num2 = scanner.nextInt()

    val calculator = Calculator()
    // 호출할 메서드를 변수 이름으로 동적으로 선택
    val aClass = calculator::class
    val method = aClass.declaredFunctions.find { it.name == methodName }
    val returnValue = method?.call(calculator, num1, num2)
    println("returnValue: $returnValue")
}
