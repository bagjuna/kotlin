package hello.io.buffered

import hello.io.buffered.BufferedConst.BUFFER_SIZE
import hello.io.buffered.BufferedConst.FILE_NAME
import hello.io.buffered.BufferedConst.FILE_SIZE
import java.io.FileOutputStream

fun main() {
    val fos = FileOutputStream(FILE_NAME)

    val startTime = System.currentTimeMillis()


    val buffer = ByteArray(BUFFER_SIZE) // 8KB 버퍼를 생성하고 1로 초기화
    var bufferIndex = 0

    for(i in 0 until FILE_SIZE) {
        buffer[bufferIndex++] = 1

        // 버파가 가득 차면 쓰고, 버퍼를 지운다
        if(bufferIndex == BUFFER_SIZE) {
            fos.write(buffer)
            bufferIndex = 0
        }
    }

    // 끝 부분에 오면 버퍼가 가득차지 않았을 수 있다. 남은 부분을 써준다
    if(bufferIndex > 0) {
        fos.write(buffer, 0, bufferIndex)
    }
    fos.close()

    val endTime = System.currentTimeMillis()
    println("File created: $FILE_SIZE")
    println("File size: ${FILE_SIZE / 1024/1024} MB")
    println("Time taken: ${endTime - startTime} ms")

}
