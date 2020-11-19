package com.darekbx.algorithms

import org.junit.Assert
import org.junit.Test
import java.util.ArrayDeque

class ValidParentheses {

    @Test
    fun tests() {
        Assert.assertFalse(solution("[])"))
        Assert.assertFalse(solution("(("))
        Assert.assertFalse(solution("("))
        Assert.assertFalse(solution("(<)>"))
        Assert.assertFalse(solution("([]<)>"))
        Assert.assertFalse(solution("(()[)"))
        Assert.assertFalse(solution(")("))
        Assert.assertTrue(solution("()"))
        Assert.assertTrue(solution("()([])"))
        Assert.assertTrue(solution("()[]{}<>"))
        Assert.assertTrue(solution("(()())[]"))
        Assert.assertTrue(solution("((()))"))
        Assert.assertTrue(solution("([{<>}])"))
        Assert.assertTrue(solution("([])([<>])"))
    }

    fun solution(input: String): Boolean {
        val opened = listOf('(', '[', '{', '<')
        val closed = listOf(')', ']', '}', '>')
        var lastOpened = ArrayDeque<Char>()
        val count = input.length

        if (count <= 1 || closed.contains(input[0])) {
            return false
        }

        for (char in input) {
            if (opened.contains(char)) {
                lastOpened.push(char)
            } else if (closed.contains(char)) {
                val openedChar = opened.elementAt(closed.indexOf(char))

                if (lastOpened.isEmpty()) {
                    return false
                }

                if (lastOpened.isNotEmpty()) {
                    val lastChar = lastOpened.pop()
                    if (lastChar != openedChar) {
                        return false
                    }
                }
            }
        }

        return lastOpened.isEmpty()
    }
}
