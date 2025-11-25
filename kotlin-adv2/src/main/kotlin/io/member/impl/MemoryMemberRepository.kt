package hello.io.member.impl

import hello.io.member.Member
import hello.io.member.MemberRepository

class MemoryMemberRepository : MemberRepository {
    private val members = mutableListOf<Member>()

    override fun add(member: Member) {
        members.add(member)
    }

    override fun findAll(): List<Member> {
        return members.toList()
    }
}
