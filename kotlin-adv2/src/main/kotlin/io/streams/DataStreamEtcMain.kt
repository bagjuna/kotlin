package hello.io.streams

import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val fos = FileOutputStream("src/main/kotlin/temp/data.dat")
    DataOutputStream(fos).use {
        it.writeUTF("회원 A")
        it.writeInt(30)
        it.writeDouble(30.0)
        it.writeBoolean(true)
        it.close()
    }
    val fis = DataInputStream(FileInputStream("src/main/kotlin/temp/data.dat"))
    fis.use {
        val name = it.readUTF()
        val age = it.readInt()
        val height = it.readDouble()
        val isMarried = it.readBoolean()

        println("name: $name")
        println("age: $age")
        println("height: $height")
        println("isMarried: $isMarried")

        it.close()
    }

}
