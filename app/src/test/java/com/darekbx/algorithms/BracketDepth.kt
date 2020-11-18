package com.darekbx.algorithms

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*
import kotlin.math.max

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
        assertEquals(-1, solution(")("))
    }

    fun solution(input: String): Int {
        val opened = listOf('(', '[', '{', '<')
        val closed = listOf(')', ']', '}', '>')
        var lastOpened = ArrayDeque<Char>()
        val count = input.length
        var maxDepth = 0
        var depth = 0

        if (count == 0 || closed.contains(input[0])) {
            return -1
        }

        for (char in input) {
            if (opened.contains(char)) {
                lastOpened.push(char)
                depth++
            } else if (closed.contains(char)) {
                val openedChar = opened.elementAt(closed.indexOf(char))

                if (lastOpened.isNotEmpty()) {
                    val lastChar = lastOpened.pop()
                    if (lastChar != openedChar) {
                        return -1
                    }
                }

                depth--
            }

            maxDepth = max(maxDepth, depth)
        }

        return maxDepth
    }
}
