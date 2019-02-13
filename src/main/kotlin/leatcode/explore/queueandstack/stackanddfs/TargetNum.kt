package leatcode.explore.queueandstack.stackanddfs

import kotlin.math.pow

/**
 * https://leetcode.com/explore/featured/card/queue-stack/232/practical-application-stack/1389/
 * P494(medium): https://leetcode.com/problems/target-sum/
 *
 * intArrayとターゲットとなる数値が与えられる
 * 与えられたintArrayの要素すべてについて、それぞれ+/-のいずれかの符号を用いて合計することで、
 * ターゲットとなる数値になる組み合わせがいくつ存在するかを返す
 *
 * - intArrayの長さは0-20(20を超えない)
 * - 要素の合計は1000を超えない
 * - 答えは32bit integerに収まることが保証される
 */
class TargetNum {
    
    fun findTargetSumWays(nums: IntArray, S: Int): Int {
        var count = 0
        val totalSum = nums.sum()
        val limit = if (nums.size == 1) 2 else 2.toFloat().pow(nums.size).toInt()
        for (i in 0 until limit) {
            var temp = totalSum
            for (shift in 0 until nums.size) {
                val bit = 1 shl shift
                if (bit and i == bit) temp -= 2 * nums[shift]
            }
            if (temp == S) count++
        }
        return count
    }
}