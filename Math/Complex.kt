package Math

data class Complex(val real: Double = 0.0, val imag: Double = 0.0){
  operator fun plus(b: Complex): Complex {
    return Complex(real + b.real, imag + b.imag)
  }

  operator fun plus(d: Double): Complex {
    return Complex(real + d, imag )
  }

  operator fun minus(b: Complex): Complex {
    return Complex(real - b.real, imag - b.imag)
  }

  operator fun minus(d: Double): Complex {
    return Complex(real - d, imag )
  }

  operator fun times(b: Complex): Complex {
    // (a + bi) * (c + di) = ac - bd +  (ad + bc)i
    return Complex(real * b.real - imag * b.imag, real * b.imag + imag * b.real)
  }

  operator fun times(d: Double): Complex {
    return Complex(real * d, imag * d)
  }

  operator fun div(b: Complex): Complex {
    return this * b.inv()
  }

  operator fun div(d: Double): Complex {
    return Complex(real / d, imag / d)
  }

  fun inv(): Complex {
    return conj() / norm()
  }

  fun conj(): Complex {
    return Complex(real, -imag)
  }

  fun abs(): Double {
    return Math.sqrt(norm())
  }

  fun norm(): Double {
    return real * real + imag * imag
  }

  fun arg(): Double {
    return Math.atan2(real, imag)
  }
}
