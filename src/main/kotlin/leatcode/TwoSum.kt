package leatcode

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = nums.mapIndexed { index, i -> i to index }.toMap()
        for (i in nums.indices) {
            val remain = target - nums[i]
            if (map.containsKey(remain)) {
                if (map[remain] != i)
                return intArrayOf(i, map.get(remain)!!)
            }
        }
        throw NoSuchElementException("solution dose not exist")
    }
}