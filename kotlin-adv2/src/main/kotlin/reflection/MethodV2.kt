package hello.reflection

import hello.reflection.data.BasicData
import kotlin.reflect.full.declaredFunctions

fun main() {
    // 정적 메서드 호출 - 일반적인 메서드 호출
    // Kotlin에서는 static이 없기 때문에 companion object를 사용
    val helloInstance = BasicData()
    helloInstance.call()    // 이 부분은 코드를 변경하지 않는 이상 정적이다.

    // 동적 메서드 호출 - reflection을 사용한 메서드 호출
    val helloClass = BasicData::class
    val methodName = "hello"

    // 메서드 이름을 변수로 변경 할 수 있다.
    val method1 = helloClass.declaredFunctions.find { it.name == methodName}
    val returnValue = method1?.call(helloInstance, "hi")
    println("returnValue: $returnValue")

}
