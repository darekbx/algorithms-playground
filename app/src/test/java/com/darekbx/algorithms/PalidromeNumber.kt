package com.darekbx.algorithms

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PalidromeNumber {

    @Test
    fun tests() {
        assertTrue(isPalindrome(0))
        assertFalse(isPalindrome(10))
        assertFalse(isPalindrome(100))
        assertFalse(isPalindrome(1000))
        assertFalse(isPalindrome(-1000))
        assertFalse(isPalindrome(-1))
        assertTrue(isPalindrome(12321))
        assertTrue(isPalindrome(432234))
        assertTrue(isPalindrome(11))
        assertTrue(isPalindrome(66))
        assertTrue(isPalindrome(9999999))
        assertTrue(isPalindrome(999999))
        assertFalse(isPalindrome(Int.MAX_VALUE))
    }

    fun isPalindrome(x: Int): Boolean {

        if (x < 0) return false
        if (x == 0) return true
        if (x % 10 == 0) return false


        var x = x
        var reverted = 0
        while(x > reverted) {
            reverted = reverted * 10 + x % 10
            x /= 10
        }
        return x == reverted || x == reverted / 10


        //for ()

        /*
        if (x < 0) return false
        val s = "$x"
        return s.reversed() == s
        */
        return false
    }
}
