package leatcode.explore.queueandstack.stackanddfs

import java.util.*

/**
 * https://leetcode.com/explore/featured/card/queue-stack/230/usage-stack/1361/
 */
class ValidParentheses {
    
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (c in s) {
            when (c) {
                in arrayOf('(', '{', '[') -> stack.push(c)
                
                in arrayOf(')', '}', ']') -> {
                    if (stack.isEmpty()) return false
                    val open = stack.pop()
                    // 文字コードが(=40, )=41, [=91, ]=93, {=123, }=125なので
                    // 数値に変換して10で割って一致していれば正しいペアということになる
                    if (open.toInt() / 10 != c.toInt() / 10) {
                        return false
                    }
                }
                
                else                      -> return false
            }
        }
        return stack.isEmpty()
    }
}