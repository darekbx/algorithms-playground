package com.darekbx.algorithms

import org.junit.Assert
import org.junit.Test

class TwoSumTest {

    @Test
    fun test_1() {
        val target = 7

        val nums = mutableListOf<Int>(1)

        (0..(Math.pow(10.0, 4.0).toInt())).forEach { nums.add(11) }
        nums.add(6)

        val s = System.currentTimeMillis()
        val result = twoSum(nums.toIntArray(), target)
        println(System.currentTimeMillis() - s)

        Assert.assertEquals(0, result[0])
        Assert.assertEquals(nums.size - 1, result[1])
    }

    @Test
    fun test_2() {
        val target = 0
        val nums = listOf<Int>(0, 4, 3, 0).toIntArray()
        val result = twoSum(nums, target)
        Assert.assertEquals(0, result[0])
        Assert.assertEquals(3, result[1])
    }

    @Test
    fun test_3() {
        val target = 9
        val nums = listOf<Int>(2, 7, 11, 15).toIntArray()
        val result = twoSum(nums, target)
        Assert.assertEquals(0, result[0])
        Assert.assertEquals(1, result[1])
    }

    @Test
    fun test_4() {
        val target = 6
        val nums = listOf<Int>(3, 2, 4).toIntArray()
        val result = twoSum(nums, target)
        Assert.assertEquals(1, result[0])
        Assert.assertEquals(2, result[1])
    }

    @Test
    fun test_5() {
        val target = -8
        val nums = listOf<Int>(-1, -2, -3, -4, -5).toIntArray()
        val result = twoSum(nums, target)
        Assert.assertEquals(2, result[0])
        Assert.assertEquals(4, result[1])
    }

    @Test
    fun test_6() {
        val target = 0
        val nums = listOf<Int>(-3, 4, 3, 90).toIntArray()
        val result = twoSum(nums, target)
        Assert.assertEquals(0, result[0])
        Assert.assertEquals(2, result[1])
    }

    @Test
    fun test_7() {
        val target = 9
        val nums = listOf<Int>(-10, 7, 19, 15).toIntArray()
        val result = twoSum(nums, target)
        Assert.assertEquals(0, result[0])
        Assert.assertEquals(2, result[1])
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val c = nums.size
        val map = HashMap<Int, Int>()
        for (i in 0 until c) {
            val n = nums[i]
            val c = target - n
            if (map.containsKey(c)) {
                return intArrayOf(map.get(c) ?: 0, i)
            }
            map.put(n, i)
        }
        return IntArray(0)
    }
}
