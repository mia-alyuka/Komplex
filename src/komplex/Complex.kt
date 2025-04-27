// Complex.kt
package komplex

import kotlin.math.atan2
import kotlin.math.sqrt

data class Complex(val re: Double, val im: Double) {
    fun conjugate(): Complex {
        return Complex(re, -im)
    }

    fun magnitude(): Double {
        return sqrt(re * re + im * im)
    }

    fun phase(): Double {
        return atan2(im, re)
    }

    fun toPolar(): Pair<Double, Double> {
        return Pair(magnitude(), phase())
    }

    operator fun unaryMinus(): Complex {
        return Complex(-re, -im)
    }

    // Complex cases
    operator fun plus(other: Complex): Complex {
        return Complex(re + other.re, im + other.im)
    }

    operator fun minus(other: Complex): Complex {
        return Complex(re - other.re, im - other.im)
    }

    operator fun times(other: Complex): Complex {
        return Complex(re * other.re - im * other.im, re * other.im + im * other.re)
    }

    operator fun div(other: Complex): Complex {
        val conj = other.conjugate()
        val upper = this * conj
        val lower = (conj * conj).re
        return upper / lower
    }

    // Int cases
    operator fun plus(other: Int): Complex {
        return Complex(re + other, im)
    }

    operator fun minus(other: Int): Complex {
        return Complex(re - other, im)
    }

    operator fun times(other: Int): Complex {
        return Complex(re * other, im * other)
    }

    operator fun div(other: Int): Complex {
        return Complex(re / other, im / other)
    }

    // Double cases
    operator fun plus(other: Double): Complex {
        return Complex(re + other, im)
    }

    operator fun minus(other: Double): Complex {
        return Complex(re - other, im)
    }

    operator fun times(other: Double): Complex {
        return Complex(re * other, im * other)
    }

    operator fun div(other: Double): Complex {
        return Complex(re / other, im / other)
    }
}
