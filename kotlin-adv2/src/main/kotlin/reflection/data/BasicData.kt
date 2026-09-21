package hello.reflection.data

import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.memberProperties


open class BasicData {

    @JvmField
    var publicField: String? = null

    private var privateField: Int = 0

    constructor() {
        println("BasicData.BasicData")
    }

    private constructor(data: String?) {
        println("BasicData.BasicData: $data")
    }

    // call, hello, privateMethod, defaultMethod, protectedMethod 는 지금 코드 그대로
    // (defaultMethod 는 코틀린에 package-private 이 없어 public 으로 컴파일됨)
    fun call() {
        println("BasicData.call")
    }


    fun hello(name: String) : String {
        println("BasicData.hello")
        return "$name, Hello"
    }

    fun privateMethod() {
        println("BasicData.privateMethod")
    }

    fun defaultMethod() {
        println("BasicData.defaultMethod")
    }

    protected fun protectedMethod() {
        println("BasicData.protectedMethod")
    }
}

class Calculator {
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun subtract(a: Int, b: Int): Int {
        return a - b
    }
}

fun main() {
    val helloClass = BasicData::class

    println("==== fields ====")
    /*Field[]*/
    val fields = helloClass.memberProperties
    for (field in fields) {
        println("field: $field")
    }

    println("==== declared fields ====")
    val declaredFields = helloClass.declaredMemberProperties
    for (field in declaredFields) {
        println("declared field: $field")
    }
}
