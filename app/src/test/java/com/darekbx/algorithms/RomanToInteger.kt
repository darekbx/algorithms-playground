package com.darekbx.algorithms

import org.junit.Assert.assertEquals
import org.junit.Test

class RomanToInteger {

    /*
    I = 1
    X = 10
    L = 50
    C = 100
    D = 500
    M = 1000

    I     II  III   IV   V   VI    VI    VII   IX  X
    XI   XII XIII  XIV  XV  XVI  XVII  XVIII  XIX XX
    XXI XXII XXII XXIV XXV XXVI XXVII XXVIII XXIX XX

    X XX XXX XL L LX LXX LXXX XC CX

     */

    @Test
    fun tests() {
        assertEquals(1, romanToInt("I"))
        assertEquals(3, romanToInt("III"))
        assertEquals(4, romanToInt("IV"))
        assertEquals(6, romanToInt("VI"))
        assertEquals(7, romanToInt("VII"))
        assertEquals(9, romanToInt("IX"))
        assertEquals(58, romanToInt("LVIII"))
        assertEquals(1994, romanToInt("MCMXCIV"))
    }

    val map = HashMap<Char, Int>().apply {
        put('I', 1)
        put('V', 5)
        put('X', 10)
        put('L', 50)
        put('C', 100)
        put('D', 500)
        put('M', 1000)
    }

    val subMap = hashMapOf(
        'I' to "VX",
        'X' to "LC",
        'C' to "DM",

        'V' to "",
        'L' to "",
        'D' to "",
        'M' to "",
    )

    fun romanToInt(s: String): Int {
        val chars = s.toCharArray()
        val count = chars.size
        var out = 0

        var skipNext = false

        for (i in 0 until count) {
            if (skipNext) {
                skipNext = false
                continue
            }

            val c = chars[i]
            val next = chars.getOrNull(i + 1)

            skipNext = true

            // Elegant solution/
            /*
            val value = when {
                next != null && subMap.getValue(c).contains(next)  -> {
                    map.getValue(next) - map.getValue(c)
                }
                else -> {
                    skipNext = false
                    map.getValue(c)
                }
            }
            */
            // Fast solution
            val value = when {
                (c == 'I' && (next == 'V' || next == 'X')) -> map.getValue(next) - map.getValue(c)
                (c == 'X' && (next == 'L' || next == 'C')) -> map.getValue(next) - map.getValue(c)
                (c == 'C' && (next == 'D' || next == 'M')) -> map.getValue(next) - map.getValue(c)
                else -> {
                    skipNext = false
                    map.getValue(c)
                }
            }

            out += value
        }

        return out
    }
}
