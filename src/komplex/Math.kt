// Math.kt
package komplex

import kotlin.math.*


fun sin(z: Complex): Complex {
    val re = sin(z.re) * cosh(z.im)
    val im = cos(z.re) * sinh(z.im)
    return Complex(re, im)
}


fun cos(z: Complex): Complex {
    val re = cos(z.re) * cosh(z.im)
    val im = -sin(z.re) * sinh(z.im)
    return Complex(re, im)
}

fun tan(z: Complex): Complex {
    return sin(z) / cos(z)
}

fun ln(z: Complex): Complex {
    return Complex(ln(z.magnitude()), z.phase())
}

fun log(z: Complex, base: Double): Complex {
    return ln(z) / ln(base)
}

fun log(z: Complex): Complex {
    return ln(z)
}

fun exp(z: Complex): Complex {
    return Complex(cos(z.im), sin(z.im)) * exp(z.re)
}

fun sqrt(z: Complex): Complex {
    val magnitude = z.magnitude()
    val phase = z.phase()
    val newMagnitude = sqrt(magnitude)
    val newPhase = phase / 2
    return exp(Complex(0.0, newPhase)) * newMagnitude
}

fun pow(base: Complex, exponent: Double): Complex {
    val magnitude = base.magnitude()
    val phase = base.phase()
    val newMagnitude = magnitude.pow(exponent)
    val newPhase = phase * exponent
    return exp(Complex(0.0, newPhase)) * newMagnitude
}

fun pow(base: Complex, exponent: Complex): Complex {
    return exp(exponent * ln(base))
}
