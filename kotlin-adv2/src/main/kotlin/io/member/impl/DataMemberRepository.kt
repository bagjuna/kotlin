package hello.io.member.impl

import hello.io.member.Member
import hello.io.member.MemberRepository
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


class DataMemberRepository: MemberRepository {
    companion object {
        // const val = 컴파일 타임 상수 (진짜 static final)
        private const val FILE_PATH = "temp/members-data.dat"
    }
    override fun add(member: Member) {
        DataOutputStream(FileOutputStream(FILE_PATH,true)).use { dos ->
            dos.writeUTF(member.id)
            dos.writeUTF(member.name)
            dos.writeInt(member.age)
        }
    }

    override fun findAll(): List<Member> {
        val members = arrayListOf<Member>()
        val file = File(FILE_PATH)
        if (!file.exists()) {
            return emptyList()
        }
        DataInputStream(FileInputStream(file)).use { dis ->
            while(dis.available() > 0) {
                val member = Member(
                    id = dis.readUTF(),
                    name = dis.readUTF(),
                    age = dis.readInt()
                )
                members.add(member)
            }
        }
        return members
    }
}
