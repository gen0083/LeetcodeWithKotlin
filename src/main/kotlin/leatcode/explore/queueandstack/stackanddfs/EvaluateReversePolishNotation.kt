package leatcode.explore.queueandstack.stackanddfs

import java.util.*

/**
 * https://leetcode.com/explore/featured/card/queue-stack/230/usage-stack/1394/
 *
 * 逆ポーランド記法による計算を行う
 * 逆ポーランド記法っていうのは1+2を1,2,+と表記するやつ
 *
 * 割り算の処理は端数を切り捨てる
 * 0除算が起こるようなinputは存在しない
 */
class EvaluateReversePolishNotation {
    
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        tokens.forEach { str ->
            try {
                val arg = str.toInt()
                stack.push(arg)
            } catch (e: NumberFormatException) {
                if (stack.size < 2) throw IllegalArgumentException("invalid input: $tokens")
                val right = stack.pop()
                val left = stack.pop()
                when (str) {
                    "+"  -> stack.push(left + right)
                    "-"  -> stack.push(left - right)
                    "*"  -> stack.push(left * right)
                    "/"  -> stack.push(left / right)
                    else -> throw IllegalArgumentException("invalid input: $tokens")
                }
            }
        }
        return stack.pop()
    }
}