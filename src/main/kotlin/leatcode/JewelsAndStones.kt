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
    
    
    // 次にHashMapを使ってSの文字種類別に出現数をカウント、Jをキーとしてカウント数を足し合わせる方法をとった
    // ただし速度は改善されない
    // 要素数分ループしているのは変わらないからだろうか
    fun numJewelsInStones(J: String, S: String): Int {
        var count = 0
        val map = hashMapOf<Char, Int>()
        S.forEach {
            map[it] = map[it]?.plus(1) ?: 1
        }
        J.forEach { count += map[it] ?: 0 }
        return count
    }
}