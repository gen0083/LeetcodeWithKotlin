package leatcode.easy

/**
 * 入力されたint値がpalindrome(回文)かどうか
 *
 * Stringへ変換せずにやるのが味噌
 * https://leetcode.com/problems/palindrome-number/
 */
class IntIsPalindrome {
    
    fun isPalindrome(x: Int): Boolean {
        val s = x.toString()
        val r = s.reversed()
        return s == r
    }
    
    fun isPalindromeWithoutStringConvert(x: Int): Boolean {
        if (x < 0) return false
        // 1の桁が0の場合はpalindromeにはなりえない(頭に0がくるintは存在しないので)
        // ただし0はpalindromeになる
        if (x > 0 && x % 10 == 0) return false
        // 考え方は大体同じだが細部が異なる
        // xを10で割っていって半分のところまで求める
        // 半分のところはx自体を10で割り続けるので、反転した値よりxが小さくなった段階で半分に達したと判断できる
        // 1の桁を取り出す→既存の反転数値を10倍にして足し込む→これで反転数値ができあがる
        // 算出対象となるxを10で割り続ければいずれ反転した数値の方が大きくなる=それが半分に到達するタイミング
        // x自体を操作するのは気持ち悪いのでtempを使っているが、値渡しだから呼び出し元に影響しないのでx使っていいけどね
        var temp = x
        var reversed = 0
        while (temp > reversed) {
            reversed = reversed * 10 + temp % 10
            temp /= 10
        }
        return temp == reversed || temp == reversed / 10
    }
}