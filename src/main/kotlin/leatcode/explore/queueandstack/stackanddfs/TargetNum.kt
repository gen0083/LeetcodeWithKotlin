package leatcode.explore.queueandstack.stackanddfs

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
        val count: MutableList<HashMap<Int, Int>> = mutableListOf(hashMapOf(0 to 1))
        for (i in 1..nums.size) {
            val line = count[i - 1]
            val possible = hashMapOf<Int, Int>()
            for ((s, c) in line) {
                val plusSum = s + nums[i - 1]
                val minusSum = s - nums[i - 1]
                if (possible.containsKey(plusSum)) {
                    val v = possible[plusSum] ?: 0
                    possible[plusSum] = v + c
                } else {
                    possible[plusSum] = c
                }
                if (possible.containsKey(minusSum)) {
                    val v = possible[minusSum] ?: 0
                    possible[minusSum] = v + c
                } else {
                    possible[minusSum] = c
                }
            }
            count.add(possible)
        }
        return count[nums.size][S] ?: 0
    }
}