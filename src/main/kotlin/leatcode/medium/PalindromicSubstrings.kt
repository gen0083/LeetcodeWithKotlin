package leatcode.medium

/**
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * 与えられた文字列のうちに回文となる部分文字列がいくつあるかを返す
 * 部分文字列が同じ文字列であっても、indexが異なれば別物としてカウントする
 * (例えばaaaという文字列のindex0:1のaaとindex1:2のaaは異なるものとしてカウントする)
 *
 * 解法をみてもさっぱり理解できないので、またどこかで出くわしたら頑張ってみる
 * TODO: Manacher's Algorithm
 * http://snuke.hatenablog.com/entry/2014/12/02/235837
 * https://qiita.com/Shawna/items/17ed870cd4c8c0f1f478
 *
 * Qiitaの解説がわかりやすいか
 * 文字列の各中心点における最長の回文を見つければいいという考え方っぽい？
 * (回文は両端を同じ長さだけ削っても回文なので、最も長い回文が見つかればその回文の長さからいくつ回文がとれるかがわかる)
 */
class PalindromicSubstrings {
    
    // 中心が奇数のときというのは例えば1文字目と2文字目の間が中心になるケース
    // つまり部分文字列が偶数長のときの話
    // leftとrightのポインタは、部分文字列が奇数なら同じ位置を示し、
    // 偶数なら最初から異なる位置を示す
    fun countSubstrings(s: String): Int {
        var count = 0
        for (center in 0 until s.length * 2) {
            var left = center / 2
            var right = left + center % 2
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                count++
                left--
                right++
            }
        }
        return count
    }
}