package hello.reflection

import hello.reflection.data.User
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.jvm.isAccessible

fun main() {
    val user = User("id1", "userA", 20)
    println("user: $user")

    val aClass = user::class
    // 메서드 이름을 변수로 변경 할 수 있다.
    val nameProperty = aClass.declaredMemberProperties.find { it.name == "name" }

    nameProperty?.isAccessible = true

    if (nameProperty is KMutableProperty<*>) {
        nameProperty.setter.call(user, "userB")
    }
    println("변경된 이름 = ${user.name}")
}
