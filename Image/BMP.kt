package Image

import java.io.File
import Image.*

class BMP(var pixels: Image, val name: String){
  private var file: File? = null

  val HEADER_SIZE = 54

  fun export(): Unit{
    file = File(this.name)
    writeHeaders()
    writePixels()
  }

  private fun writeHeaders(): Unit {
    file?.writeText("BM")
    val size = HEADER_SIZE + pixels.width * pixels.height;
    writeInteger(size)
    val reserverd = 0
    writeInteger(reserverd)
    val offset = 0x36
    writeInteger(offset);
    val headerSize = 40;
    writeInteger(headerSize);
    writeInteger(pixels.width)
    writeInteger(pixels.height)
    val planes = 1
    writeShort(planes)
    val bits = 24
    writeShort(bits)
    val compression = 0
    writeInteger(compression)
    val paleteSize = 0
    writeInteger(paleteSize)
    val bpiX = 0
    val bpiY = 0
    writeInteger(bpiX)
    writeInteger(bpiY)
    val usedColors = 0
    val importantColors = 0
    writeInteger(usedColors)
    writeInteger(importantColors)
  }

  private fun writeInteger(n: Int){
    writeShort(n.and(0xFFFF))
    writeShort(n.shr(16))
  }

  private fun writeByte(n: Int){
    val arr = ByteArray(1)
    arr[0] = n.toByte()
    file!!.appendBytes(arr)
  }

  private fun writeShort(n: Int){
    writeByte(n.and(0xFF))
    writeByte(n.shr(8).and(0xFF))
  }

  private fun writePixels(){
    /*val adjustment = (4 - (pixels.width * 3) % 4) % 4;*/
    for(row in pixels.pixels){
      for(pixel in row){
        writeByte(pixel.blue)
        writeByte(pixel.green)
        writeByte(pixel.red)
      }
      /*for(val j=0;j<ajuste;j++)
      f<<'\0';*/
    }
  }
}
