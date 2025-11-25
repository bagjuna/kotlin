package hello.io.member

import java.io.Serializable

// 기본 생성자

data class Member
    (
    val id: String,
    val name: String,
    val age: Int
) : Serializable{
    // 부 생성자
    constructor() : this("default", "default", 0)

 }

