package leatcode

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in 0 until nums.size) {
            val remain = target - nums[i]
            val j = nums.slice(i + 1 until nums.size).indexOf(remain)
            if (j > -1) {
                return intArrayOf(i, j + i + 1)
            }
        }
        return intArrayOf(0, 1)
    }
}