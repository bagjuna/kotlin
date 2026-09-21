package hello.reflection

import hello.reflection.data.BasicData
import kotlin.reflect.full.superclasses

fun main() {
    val basicData = BasicData::class

    println("qualifiedName = ${basicData.qualifiedName}")
    println("simpleName = ${basicData.simpleName}")
    println("package = ${basicData.java.packageName}")   // JDK 9+

    println("superclasses = ${basicData.superclasses}")   // [class kotlin.Any]
    println("interfaces = ${basicData.superclasses.filter { it.java.isInterface }}")
    println("isInterface = ${basicData.java.isInterface}")
    println("isEnum = ${basicData.java.isEnum}")

    println("visibility = ${basicData.visibility}")       // PUBLIC
    println("isFinal = ${basicData.isFinal}")
    println("isOpen = ${basicData.isOpen}")                // open class로 선언했다면 true
    println("isAbstract = ${basicData.isAbstract}")



}
