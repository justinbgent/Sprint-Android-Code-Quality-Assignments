package com.example.calculatorunittest

class Calculator(private val math: Math) {
    fun difference(x: Int, y: Int): Int{
        return math.differenceOfNumbersAbsoluteVal(x, y)
    }

    fun factorial(x: Int): Int?{
        var result = 1
        if (x > 1)
        for(i in 1..x){
            result *= i
        }else if(x < 0){
            return null
        }
        return result
    }

    fun sqrtSums(x: Double, y: Double): Double{
        return math.sumOfPositiveNumbersSquareRoots(x, y)
    }
}