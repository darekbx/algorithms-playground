package com.darekbx.algorithms

import org.junit.Assert.assertEquals
import org.junit.Test

class BracketDepth {

    @Test
    fun tests() {
        assertEquals(1, solution("()"))
        assertEquals(2, solution("()([])"))
        assertEquals(1, solution("()[]{}<>"))
        assertEquals(2, solution("(()())[]"))
        assertEquals(3, solution("((()))"))
        assertEquals(4, solution("([{<>}])"))
        assertEquals(3, solution("([])([<>])"))
        assertEquals(-1, solution("(<)>"))
        assertEquals(-1, solution("([]<)>"))
        assertEquals(-1, solution("(()[)"))
    }

    fun solution(s: String): Int {

        

    }
}
