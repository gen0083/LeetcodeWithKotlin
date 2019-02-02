package leatcode.easy

/**
 * P496: https://leetcode.com/problems/next-greater-element-i/
 *
 * 2つのIntArrayが与えられる
 * nums1はnums2のサブセット
 * 数値に重複はない
 * nums1で指定される数について、nums2の配列においてその数より後ろに存在する数の中でもっとも早く出現する大きい数を返す
 * 大きい数が存在しない場合は-1を返す
 *
 */
class NextGreaterElement1 {
    
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        // num1の位置
        val indexes = IntArray(nums1.size) { -1 }
        val out = IntArray(nums1.size) { -1 }
        nums2.forEachIndexed { i, n ->
            for (j in 0 until nums1.size) {
                if (indexes[j] != -1) {
                    // nums1で指定された数の開始位置は過ぎている
                    // すでに大きい数が検出されている場合次のnums1に移動
                    if (out[j] != -1) continue
                    // compare and search greater number
                    if (nums1[j] < n) {
                        out[j] = n
                    }
                } else {
                    // nums1で指定された数かどうかを判定する
                    if (nums1[j] == n) {
                        indexes[j] = i
                    }
                }
            }
        }
        return out
    }
}