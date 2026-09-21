package hello.reflection.data

class User (
    var id: String,
    var name: String,
    var age: Int,
){

    override fun toString(): String {
        return "User(id=$id, name=$name, age=$age)"
    }
}
