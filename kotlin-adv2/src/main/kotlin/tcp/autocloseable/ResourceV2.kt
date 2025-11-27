package hello.tcp.autocloseable

class ResourceV2(private val name: String): AutoCloseable {

    fun call() {
        println("$name call()")
    }

    fun callEx() {
        println("$name callEx")
        throw CallException("$name ex")
    }


    override fun close() {
        println("$name close()")
        throw CloseException("$name ex")
    }



}
