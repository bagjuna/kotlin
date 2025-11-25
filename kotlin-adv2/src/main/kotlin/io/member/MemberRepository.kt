package hello.io.member

interface MemberRepository {
    fun add(member: Member)

    fun findAll(): List<Member>


}
