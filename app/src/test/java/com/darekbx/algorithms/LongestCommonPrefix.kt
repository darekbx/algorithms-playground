package com.darekbx.algorithms

import org.junit.Assert.assertEquals
import org.junit.Test

class LongestCommonPrefix {

    @Test
    fun tests() {
        assertEquals("flower", longestCommonPrefix(arrayOf("flower","flower","flower","flower")))
        assertEquals("fl", longestCommonPrefix(arrayOf("flower","flow","flight")))
        assertEquals("f", longestCommonPrefix(arrayOf("flower","fiow","flight")))
        assertEquals("a", longestCommonPrefix(arrayOf("ab","a")))
        assertEquals("a", longestCommonPrefix(arrayOf("aa","ab")))
        assertEquals("aa", longestCommonPrefix(arrayOf("aaa","aa","aaa")))
        assertEquals("", longestCommonPrefix(arrayOf("dog","racecar","car")))
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }

        if (strs.size == 1) {
            return strs[0]
        }

        val minLength = 200

        for (i in 1 until minLength + 1) {
            val prefix = strs[0].take(i)
            if (!strs.all { it.take(i) == prefix }) {
                if (i > 1) {
                    return strs[0].take(i - 1)
                } else if (i == 1) {
                    return ""
                } else {
                    return strs[0].take(i)
                }
            }
        }

        return strs[0]
    }
}
