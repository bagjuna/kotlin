package hello.reflection

fun main() {

    val aClass = Class.forName("hello.reflection.data.BasicData")

    println("==== constructor ====")
    val constructors = aClass.constructors
    constructors.forEach { constructor ->
        println(constructor)
    }

    println("==== declared constructor ====")
    val declaredConstructors = aClass.declaredConstructors
    declaredConstructors.forEach { constructor ->
        println(constructor)
    }
}
