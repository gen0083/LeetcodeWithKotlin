package leatcode.medium

/**
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * 与えられた文字列のうちに回文となる部分文字列がいくつあるかを返す
 * 部分文字列が同じ文字列であっても、indexが異なれば別物としてカウントする
 * (例えばaaaという文字列のindex0:1のaaとindex1:2のaaは異なるものとしてカウントする)
 */
class PalindromicSubstrings {
    
    // 全組み合わせをチェックする単純なパターン
    // 当然遅い
    fun countSubstrings(s: String): Int {
        var count = 0
        for (i in 0 until s.length) {
            for (j in i until s.length) {
                if (s[i] != s[j]) continue
                val sub = s.substring(i, j + 1)
                if (sub == sub.reversed()) {
                    count++
                }
            }
        }
        return count
    }
}