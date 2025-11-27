package hello.tcp.autocloseable

class ResourceV1(private val name: String){

    fun call() {
        println("$name call()")
    }

    fun callEx() {
        println("$name callEx")

        throw CallException("$name ex")
    }

    fun close() {
        println("$name close()")
    }


    fun closeEx() {
        println("$name closeEx()")
        throw CloseException("$name ex")
    }

}
