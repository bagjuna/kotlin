package hello.reflection

import hello.reflection.data.Team
import hello.reflection.data.User

fun main() {
    val user = User("id1", null, null)
    val team = Team("team1", null)
    println("==== before ====")
    println("user: $user")
    println("team: $team")

    if(user.id == null) {
        user.id = ""
    }

    if(user.name == null) {
        user.name = ""
    }

    if(user.age == null) {
        user.age = 0
    }

    if(team.id == null) {
        team.id = ""
    }

    if(team.name == null) {
        team.name = ""
    }


    println("==== after ====")
    println("user: $user")
    println("team: $team")

}
