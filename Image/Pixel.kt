package Image

data class Pixel(val red: Int = 0, val green: Int = 0, val blue: Int= 0){
  companion object {
    val Blue   = Pixel(0, 0, 255)
    val Red    = Pixel(255, 0, 0)
    val White  = Pixel(255, 255, 255)
    val Green  = Pixel(0, 255, 0)
    val Yellow = Pixel(255, 255, 0)
    val Purple = Pixel(255, 0, 255)
    val Cyan   = Pixel(0, 255, 255)
    val Orange = Pixel(255, 128, 0)
    val Black  = Pixel(0, 0, 0)
    val Brown  = Pixel(153, 76, 0)
    val Pink   = Pixel(255, 153, 204)
  }

  operator fun times(d: Double): Pixel{
    return Pixel((red * d).toInt(), (green * d).toInt(), (blue * d).toInt())
  }
}
