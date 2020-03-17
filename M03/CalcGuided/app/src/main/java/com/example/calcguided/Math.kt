package com.example.calcguided

class Math {
    fun addIntegers(a: Int, b: Int): Int{
        // TODO: Write Implementation
        return a + b
    }

    fun mutltiplyIntegers(a: Int, b: Int): Int{
        return a * b
    }

    fun divideIntegers(a: Int, b: Int): Int{
        val integerVal = a / b
        val modulo = a % b
        return integerVal
    }
}