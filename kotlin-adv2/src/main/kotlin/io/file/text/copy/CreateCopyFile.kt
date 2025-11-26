package hello.io.file.text.copy

import java.io.FileOutputStream


fun main() {
    val FILE_SIZE = 200 * 1024 * 1024 // 200MB

    val fileName = "src/main/kotlin/temp/copy.dat"
    val startTime = System.currentTimeMillis()

//    FileOutputStream(fileName).use {
//        val buffer = ByteArray(FILE_SIZE) // 1MB 버퍼
//        it.write(buffer)
//    }

    val fos = FileOutputStream(fileName)
    val buffer = ByteArray(FILE_SIZE)
    fos.write(buffer)
    fos.close()


    val endTime = System.currentTimeMillis()
    println("File Created: $fileName")
    println("Time taken: ${endTime - startTime} ms")


}
