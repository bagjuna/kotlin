package hello.reflection.data


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
}
