package hello.reflection

import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.declaredMemberProperties

object FieldUtil {

    fun nullFieldToDefault(target: Any) {
        val klass = target::class
        val declaredMemberProperties = klass.declaredMemberProperties
        for (property in declaredMemberProperties) {
            if(property.call(target) != null) {
                continue
            }
            when (property.returnType.classifier) {
                String::class -> {
                    if (property is KMutableProperty<*>) {
                        property.setter.call(target, "")
                    }
                }
                Int::class -> {
                    if (property is KMutableProperty<*>) {
                        property.setter.call(target, 0)
                    }
                }
            }
        }
    }

}
