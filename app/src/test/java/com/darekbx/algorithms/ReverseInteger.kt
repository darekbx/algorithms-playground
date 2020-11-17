package com.darekbx.algorithms

import junit.framework.Assert.assertEquals
import org.junit.Test

class ReverseInteger {

    @Test
    fun tests() {
        assertEquals(321, reverse(123))
        assertEquals(-321, reverse(-123))
        assertEquals(21, reverse(120))
        assertEquals(0, reverse(0))
        assertEquals(0, reverse(1534236469))
        assertEquals(0, reverse(-2147483648))
    }

    fun reverse(x: Int): Int {
        if (x == 0) return 0
        if (x < 0) {
            val s = kotlin.math.abs(x).toString().reversed().toIntOrNull()
            return (s ?: 0) * -1
        } else {
            val s = x.toString().reversed().toIntOrNull()
            return s ?: 0
        }
    }
}
