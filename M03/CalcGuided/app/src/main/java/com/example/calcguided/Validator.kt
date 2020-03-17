package com.example.calcguided

class Validator {
    fun isStringPalindrome(string: String): Boolean{
        val adjusted = string.toLowerCase().replace(" ", "")
        val reverse = adjusted.reversed()
        var result = true
        adjusted.forEachIndexed { index, loweredChar ->
            if (loweredChar != reverse[index]){
                result = false
            }
        }
        return result
    }
}