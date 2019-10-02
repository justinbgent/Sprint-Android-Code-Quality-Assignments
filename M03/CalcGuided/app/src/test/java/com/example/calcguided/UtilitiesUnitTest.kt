package com.example.calcguided

import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class UtilitiesUnitTest {
    private val validator = mock(Validator::class.java)
    private val utilities = Utilities(validator)

    @Test
    fun utilityCallTest_Valid(){

        val string = "madam"
        `when`(validator.isStringPalindrome(string)).thenReturn(true)

        val result = utilities.checkIfStringIsPalindrome(string)

        assert(result)
    }

    @Test
    fun utilityCallTest_Invalid(){

        val string = "madam"
        `when`(validator.isStringPalindrome(string)).thenReturn(false)

        val result = utilities.checkIfStringIsPalindrome(string)

        assert(!result)
    }

    @Test
    fun palindromeCheck_Valid(){
        val string = "racecar"
        val validator = Validator()

        val result = validator.isStringPalindrome(string)

        assert(result)
    }

    @Test
    fun palindromeCheck_FirstLastMatch(){
        val string = "lambdaschool"
        val validator = Validator()

        val result = validator.isStringPalindrome(string)

        assert(!result)
    }

    @Test
    fun palindromeCheck_Invalid(){
        val string = "android"
        val validator = Validator()

        val result = validator.isStringPalindrome(string)

        assert(!result)
    }

    @Test
    fun palindromeCheck_Spaces(){
        val string = "a man a plan a canal panama"
        val validator = Validator()

        val result = validator.isStringPalindrome(string)

        assert(result)
    }

    @Test
    fun palindromeCheck_Capitals(){
        val string = "lEvel"
        val validator = Validator()

        val result = validator.isStringPalindrome(string)

        assert(result)
    }


}