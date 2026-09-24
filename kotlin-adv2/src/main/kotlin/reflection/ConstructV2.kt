package hello.reflection

import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.jvm.isAccessible


fun main() {

    val kClass = Class.forName("hello.reflection.data.BasicData").kotlin

    val constructor = kClass.constructors.find { it.parameters.size == 1 }

    // 3. private 생성자 접근 허용
    constructor?.isAccessible = true

    // 4. 인스턴스 생성 (call 사용)
    val instance = constructor?.call("hello")
    println("instance = $instance")

    // 5. "call" 메서드를 찾아 실행
    if (instance != null) {
        val method1 = kClass.declaredFunctions.find { it.name == "call" }
        method1?.call(instance)
    }
}
