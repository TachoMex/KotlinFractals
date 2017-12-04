package Math
import Math.Complex
import Image.*


class Mandelbrot(val width: Int, val height: Int, val iter: Int, val begin: Complex, val end: Complex, val bound: Double, val iterate: (Complex, Complex) -> Complex){
  private var iterations = Array<IntArray>(width, { _ -> IntArray(height)})

  fun calculate(): Unit{
    val deltaReal = (end.real - begin.real) / width;
    val deltaImag = (end.imag - begin.imag) / height;

    for(i in 0..width - 1){
      println(i.toString() + "/" + width)
      for(j in 0..height - 1){
        val y = begin.real + deltaReal * i
        val x = begin.imag + deltaImag * j
        var z = Complex()
        val c = Complex(x, y)
        var k = 0
        while(k < iter){
          if(z.abs() > bound){
            break
          }
          z = iterate(z, c)
          k++
        }
        iterations[i][j] = k
      }
    }
  }

  fun exportImage(mapper: (Int, Int) -> Pixel): Image{
    val pixels = Array<Array<Pixel>>(width, { i -> Array<Pixel>(height, { j -> mapper(iterations[i][j], iter) })})
    return Image(pixels, width, height)
  }
}
