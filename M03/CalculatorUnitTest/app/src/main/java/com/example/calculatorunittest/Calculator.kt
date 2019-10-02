package com.example.calculatorunittest

class Calculator(private val math: Math) {
    fun difference(x: Int, y: Int): Int{
        return math.differenceOfNumbersAbsoluteVal(x, y)
    }

    fun factorial(x: Double, y: Double): Double{
        return math.sumOfPositiveNumbersSquareRoots(x, y)
    }
}