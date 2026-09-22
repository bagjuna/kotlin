package hello.reflection

import hello.reflection.data.Team
import hello.reflection.data.User

fun main() {
    val user = User("id1", null, null)
    val team = Team("team1", null)
    println("==== before ====")
    println("user: $user")
    println("team: $team")

    FieldUtil.nullFieldToDefault(user)
    FieldUtil.nullFieldToDefault(team)

    println("==== after ====")
    println("user: $user")
    println("team: $team")
}
