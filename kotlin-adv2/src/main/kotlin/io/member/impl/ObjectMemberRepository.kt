package hello.io.member.impl

import hello.io.member.Member
import hello.io.member.MemberRepository
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class ObjectMemberRepository : MemberRepository {
    companion object {
        private const val FILE_PATH = "temp/members-object.dat"
    }

    override fun add(member: Member) {

        val members = findAll().toMutableList()
        members.add(member)


        ObjectOutputStream(FileOutputStream(FILE_PATH)).use { oos ->
            oos.writeObject(members)

        }
    }

    override fun findAll(): List<Member> {

        val file = File(FILE_PATH)
        if (!file.exists()) {
            return emptyList()
        }
        ObjectInputStream(FileInputStream(file)).use { ois ->
            return ois.readObject() as? List<Member> ?: emptyList()
        }


    }
}
