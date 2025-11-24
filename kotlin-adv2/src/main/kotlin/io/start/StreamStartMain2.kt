package hello.io.start

import java.io.FileInputStream
import java.io.FileOutputStream


fun main(){

    val fos = FileOutputStream("src/main/kotlin/temp/hello.dat")
    fos.write(65)
    fos.write(66)
    fos.write(67)
    fos.close()

    val fis = FileInputStream("src/main/kotlin/temp/hello.dat")
    var data : Int

    while ((fis.read().also { data = it }) != -1){
        println(data)
    }


    fis.close()
}
