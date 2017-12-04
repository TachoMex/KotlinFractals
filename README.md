# Kotlin Fractals

Demo on kotlin for calculating fractals. Currently it only supports Mandelbrot fractal.

There are also some helpers for calculating them:
- Complex number implementation
- Barely BMP writter along a RGB pixel model

To generate a fractal:

```kotlin
import Image.*
import Math.Complex
import Math.Mandelbrot

fun main(args: Array<String>){
  // this calculate mandelbrot over a 800x800 image.
  // It goes from (-2, -2) to (2, 2) space
  // it will stop when the norm is more than 4
  // and the iteration function, which takes z the iteration
  // and c the constant
  var m = Mandelbrot(800, 800, 100,
                     Complex(-2.0, -2.0),
                     Complex(2.0, 2.0),
                     4.0,
                     { z, c -> z * z + c })
  m.calculate()
  // mandelbrot can be exported to an image with a mapper function,
  // that function receives the iterations it took to "escape" and the total
  // iterations.
  BMP(m.exportImage({ k, n -> Pixel.Blue * (k.toDouble() / n.toDouble()) }),
      "Mandelbrot.bmp").export()
}

```

# Known Issues
- The BMP exporter does not work with images that are not modulo 4 congruent on width.

# Future Work
I'm not pretty sure if I'm going to continue with this work, but here is what can
be done to improve the repository. I migrated this from a c++ repository I own but
that I implemented while College, so this is like a refactor of that, I guess.
- Implement more operations with Complex numbers (sin, cos, exp, log, etc).
- Implement pixel operations (convert to gray scale, an HSL implementation, substraction, add, etc).
- Implement convolutive filters over Image class.
- Implement BMP importing.
- Implement shape drawing over the image (line, circles, parable, ellipse, polygons, besier curves, filler).
