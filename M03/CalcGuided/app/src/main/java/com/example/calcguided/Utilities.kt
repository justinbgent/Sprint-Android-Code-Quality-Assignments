package com.example.calcguided

class Utilities(private val validator: Validator) {
    fun checkIfStringIsPalindrome(original: String): Boolean{
        return validator.isStringPalindrome(original)
    }
}