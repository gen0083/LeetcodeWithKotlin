package leatcode.easy

class IntIsPalindrome {
    fun isPalindrome(x: Int): Boolean {
        val s = x.toString()
        val r = s.reversed()
        return s == r
    }
    
    fun isPalindromeWithoutStringConvert(x: Int): Boolean {
        if (x < 0) return false
        val list = mutableListOf<Int>()
        var temp = x
        var i = 0
        var scale = 10
        while (temp > 0) {
            val n = temp % scale
            list.add(n)
            temp /= scale
            i++
        }
        val limit = list.size / 2
        for (i in 0 until limit) {
            if (list[i] != list[list.size - i - 1]) return false
        }
        return true
    }
}