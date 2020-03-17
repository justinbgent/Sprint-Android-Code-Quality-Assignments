package com.example.calcguided

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MathUnitTest {


    @Test
    fun calculatorAddition() {
        // Setup
        val num1 = 10
        val num2 = 4
        val expected = 14

        val math = mock(Math::class.java)
        `when`(math.addIntegers(num1, num2)).thenReturn(expected)

        val calculator = Calculator(math)
        //Execute
        val sum = calculator.add(num1, num2)

        //Check
        assertEquals(expected, sum)
    }

    @Test
    fun viewModelSummation(){
        val num1 = 0
        val num2 = 7
        val expected = 0

        val viewModel = CalculatorViewModel()

        val calculator = mock(Calculator::class.java)
        `when`(calculator.add(num1, num2)).thenReturn(expected)
        viewModel.calculator = calculator

        val sum = viewModel.summation(num1, num2)

        assertEquals(expected, sum)


    }

    @Test
    fun testAddIntegers(){
        val math = Math()

        val sum = math.addIntegers(1, 5)
        assertEquals(6, sum)
    }

    @Test
    fun testMultiplyIntegers(){
        //Setup
        val num1 = 3
        val num2 = 4
        val expectedResult = 12
        val math = Math()

        //Execute
        val product = math.mutltiplyIntegers(num1, num2)
        assertEquals(expectedResult, product)
    }

    @Test
    fun testMultiplyIntegersB(){
        //Setup
        val num1 = 32
        val num2 = 2
        val expectedResult = 64
        val math = Math()

        //Execute
        val product = math.mutltiplyIntegers(num1, num2)
        assertEquals(expectedResult, product)
    }
}