package com.example.calcguided

import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    lateinit var calculator: Calculator

    fun summation(a: Int, b: Int): Int{
        return calculator.add(a, b)
    }
}