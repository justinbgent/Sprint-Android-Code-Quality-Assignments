package com.example.calculatorunittest

import kotlin.math.absoluteValue
import kotlin.math.sqrt

class Math {
    fun sumOfPositiveNumbersSquareRoots(x: Double, y: Double): Double{
        val xSquareRoot = sqrt(x)
        val ySquareRoot = sqrt(y)

        return xSquareRoot + ySquareRoot
    }

    fun differenceOfNumbersAbsoluteVal(x: Int, y: Int): Int{
        return x.absoluteValue - y.absoluteValue
    }
}