package hello.reflection.data

class Team(
    var id: String,
    var name: String?,
) {


    override fun toString(): String {
        return "Team(id=$id, name=$name)"
    }
}
