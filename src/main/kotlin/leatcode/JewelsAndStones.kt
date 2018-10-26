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
    // ただし速度は改善されない（というかどうやっても大差ないみたい）
    // 要素数分ループしているのは変わらないからだろうか
    // leatcode上での実行時間を基準にすると、実行タイミングによって結果が変わる
    // そもそもやり方によって大差が生まれない問題であれば誤差なので当てにならなそう（Kotlinは特に）
    fun numJewelsInStones(J: String, S: String): Int {
        return S.filter {J.contains(it)}.length
    }
}