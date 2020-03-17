package com.example.calculatorunittest

import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import kotlin.test.assertEquals

class CalculatorUnitTests {

    private val mathMock = mock(Math::class.java)
    private val calc = Calculator(mathMock)

    @Test
    fun differencePositiveVals(){
        val num1 = 10
        val num2 = 8
        val expected = 2

        `when`(mathMock.differenceOfNumbersAbsoluteVal(num1, num2)).thenReturn(expected)

        val result = calc.difference(num1, num2)

        assertEquals(expected, result)
    }

    @Test
    fun differenceNegativeVals(){
        val num1 = -5
        val num2 = -7
        val expected = -2

        `when`(mathMock.differenceOfNumbersAbsoluteVal(num1, num2)).thenReturn(expected)

        val result = calc.difference(num1, num2)

        assertEquals(expected, result)
    }

    @Test
    fun differenceWithoutMock(){
        val num1 = 10
        val num2 = -12
        val expected = -2

        val math = Math()
        val calculator = Calculator(math)
        val result = calculator.difference(num1, num2)

        assertEquals(expected, result)
    }

    @Test
    fun sqrtSumesInputSmallNums(){
        val num1 = 9.0
        val num2 = 16.0
        val expected = 7.0

        `when`(mathMock.sumOfPositiveNumbersSquareRoots(num1, num2)).thenReturn(expected)

        val result = calc.sqrtSums(num1, num2)

        assertEquals(expected, result)
    }

    @Test
    fun sqrtSumesInputBigNums(){
        val num1 = 144.0
        val num2 = 81.0
        val expected = 21.0

        `when`(mathMock.sumOfPositiveNumbersSquareRoots(num1, num2)).thenReturn(expected)

        val result = calc.sqrtSums(num1, num2)

        assertEquals(expected, result)
    }

    @Test
    fun sqrtSumesWithoutMock(){
        val num1 = 144.0
        val num2 = 81.0
        val expected = 21.0

        val math = Math()
        val calculator = Calculator(math)
        val result = calculator.sqrtSums(num1, num2)

        assertEquals(expected, result)
    }

    @Test
    fun factorialTest(){
        val num = 4
        val expected = 24

        val result = calc.factorial(num)

        assertEquals(expected, result)
    }

    @Test
    fun factorialNegativeInt(){
        val num = -4
        val expected = null

        val result = calc.factorial(num)

        assertEquals(expected, result)
    }

    @Test
    fun factorialZero(){
        val num = 0
        val expected = 1

        val result = calc.factorial(num)

        assertEquals(expected, result)
    }
}