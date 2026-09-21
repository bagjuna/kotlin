package hello.reflection

import hello.reflection.data.BasicData
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.functions

fun main() {
    val helloClass = BasicData::class

    println("==== methods ====")
    /*Method[]*/
    val methods = helloClass.functions
    for (method in methods) {
        println("method: $method")
    }

    println("==== declared methods ====")
    val declaredMethods = helloClass.declaredFunctions
    for (method in declaredMethods) {
        println("declared method: $method")
    }
}
