package hello.io.member

import hello.io.member.impl.DataMemberRepository
import hello.io.member.impl.FileMemberRepository
import hello.io.member.impl.MemoryMemberRepository
import java.util.*


//val repository: MemberRepository = MemoryMemberRepository()
//val repository: MemberRepository = FileMemberRepository()
val repository: MemberRepository = DataMemberRepository()

fun main() {


    val sc = Scanner(System.`in`)
    while (true) {
        println("1. 회원 등록 | 2. 회원 조회 | 3. 종료")
        print("선택: ")
        val choice = sc.nextInt()

        when(choice) {
            1 ->{
                registerMember(sc)
                // 회원 등록
            }
            2 ->{
                // 회원 조회
                displayMembers()
            }
            3 ->{
                println("프로그램 종료")
                return
            }
            else ->{
                println("잘못된 선택입니다.")
            }
        }

    }
}

fun registerMember(sc: Scanner){
    print("ID 입력: ")
    val id = sc.next()

    print("이름 입력: ")
    val name = sc.next()

    print("나이 입력: ")
    val age = sc.nextInt()

    sc.nextLine() // 버퍼에 남은 엔터 제거
    val member = Member(id, name, age)

    repository.add(member)
    println("회원이 성공적으로 등록 되었습니다.  $name")
}

fun displayMembers(){
    val members = repository.findAll()
    for (member in members) {
        println("[ID: ${member.id}, Name: ${member.name}, Age: ${member.age}]")
    }

}
