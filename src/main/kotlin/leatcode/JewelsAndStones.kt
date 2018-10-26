package leatcode

/**
 * https://leetcode.com/problems/jewels-and-stones/
 *
 * a-z,A-Zの文字列が与えられるJが宝石を表し、Sの中に宝石がいくつあるかを求める
 * - 小文字と大文字は区別される
 * - Jに重複はない
 * - JとSともに文字列からなる
 * - それぞれ長さは最大で50
 */
class JewelsAndStones {
    
    
    // 単純に思いつくのは、SをループしてJの要素数分ループして検証する方法
    // 計算量オーダーはどう求めるのかはよくわからんが、O(n^2)扱い？
    // まったくもってスマートじゃない
    // Jの数が多くなればなるほど検索の手間が激しい
    // 自前でループしないとしても、containで判定したとしても、そのcontainが結局ループで検索するのでは意味がないしね
    fun numJewelsInStones(J: String, S: String): Int {
        var count = 0
        for (i in S.indices) {
            // containsは内部でforループしてる
            if (J.contains(S[i])) count++
        }
        return count
    }
}