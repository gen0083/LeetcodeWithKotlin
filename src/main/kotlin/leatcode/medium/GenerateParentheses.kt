package leatcode.medium

/**
 * P22: https://leetcode.com/problems/generate-parentheses/
 *
 * nが与えられるので、その与えられたn個の()ペアで作成可能な組み合わせを列挙する
 *
 */
class GenerateParentheses {
    
    /**
     * n-1の結果に対して
     * 1. ([n-1の結果])
     * 2. [n-1の結果]()
     * 3. ()[n-1の結果]
     * と順番に足していけばすべてのパターンが網羅できるという考え方による解法。
     * ただしテストケースを通すためには指定された順番であることも求められるため、これだとクリアにならない。
     * TODO: 出力順を求められるとおりに変更する
     */
    fun generateParenthesis(n: Int): List<String> {
        if (n <= 0) return emptyList()
        val out = mutableListOf("()")
        for (i in 1 until n) {
            val tmp = out.toList()
            out.clear()
            tmp.forEach {
                out.add("($it)")
                out.add("$it()")
                out.add("()$it")
            }
        }
        return out.distinct().sorted()
    }
}