package hello.io.member.impl

import hello.io.member.Member
import hello.io.member.MemberRepository
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import kotlin.text.Charsets.UTF_8

const val FILE_PATH = "temp/members-txt.dat"
const val DELIMITER = ','

class FileMemberRepository: MemberRepository {

    override fun add(member: Member) {
        BufferedWriter(FileWriter(FILE_PATH,UTF_8, true)).use { bw ->
            bw.write("${member.id}$DELIMITER${member.name}$DELIMITER${member.age}")
            bw.newLine()
        }


    }

    override fun findAll(): List<Member> {
        val file = File(FILE_PATH)
        if (!file.exists()) { // 파일이 없으면
            return emptyList() // 그냥 빈 리스트 주고 끝냄
        }
        val members = arrayListOf<Member>()
        BufferedReader(FileReader(file,UTF_8)).use { reader ->
            // id1, name1, age1
            var line: String?

            while((reader.readLine()).also{ line = it } != null) {
                val tokens = line!!.split(DELIMITER)
                if (tokens.size == 3) {
                    val member = Member(
                        id = tokens[0],
                        name = tokens[1],
                        age = tokens[2].toInt()
                    )
                    members.add(member)
                }
            }
            return members
        }
    }
}
