package leatcode.medium

/**
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * 与えられた文字列のうちに回文となる部分文字列がいくつあるかを返す
 * 部分文字列が同じ文字列であっても、indexが異なれば別物としてカウントする
 * (例えばaaaという文字列のindex0:1のaaとindex1:2のaaは異なるものとしてカウントする)
 */
class PalindromicSubstrings {
    
    // reverseメソッドを使わずに回文チェック
    // reverseを使うと内部でforループを使って文字列の入れ替えを行う
    // 始点と終点、始点+1と終点-1、...というチェックを行えば入れ替えるよりは効率的に回文かどうかが確認できる
    // 三重ループになっているが、もともとreverseを使っている部分でforループが走っていた
    fun countSubstrings(s: String): Int {
        var count = 0
        for (i in 0 until s.length) {
            for (j in i + 1 until s.length) {
                var isPalindrome = true
                for (step in 0..(j - i) / 2) {
                    if (s[i + step] != s[j - step]) {
                        isPalindrome = false
                        break
                    }
                }
                if (isPalindrome) {
                    count++
                }
            }
        }
        count += s.length
        return count
    }
}