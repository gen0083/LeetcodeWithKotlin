package leatcode.medium

/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * 2つの数値の入力を受け取って加算を行う。ただし入力された数字は逆の順番になっている。
 * (つまり、123の入力は[3, 2, 1]という順番で渡されることを意味する)
 * 出力もまた逆順で返す。(246を帰す場合は[6, 4, 2]を返すということ)
 *
 * 条件: 入力には0も存在する。ただし、leading zeroは存在しないのでそれは考慮する必要がない。
 *
 * 入力データの形式はListNodeというクラスが使われる。
 * Kotlinチックではないが、これはこのテストの仕様なので気にしない。
 */
class AddTwoNumbers {
    
    // 基本的な処理はこの考え方でOK、解法との差は余計な変数定義があるかどうかの違い
    // 例えばこのやり方だと一旦List<Int>に各桁の計算結果を格納してループが終わってからListNodeを作成しているが、
    // そんなことをしなくても計算を行うwhileループの部分で直接ListNodeを作成してしまえば良い
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var t1 = l1
        var t2 = l2
        var isCarry = false
        val result = mutableListOf<Int>()
        while (t1 != null || t2 != null) {
            val i = t1?.`val` ?: 0
            val j = t2?.`val` ?: 0
            val n = if (isCarry) i + j + 1 else i + j
            result.add(n % 10)
            isCarry = n >= 10
            t1 = t1?.next
            t2 = t2?.next
        }
        if (isCarry) result.add(1)
        
        val root = ListNode(result[0])
        var t = root
        for (i in 1 until result.size) {
            t.next = ListNode(result[i])
            t = t.next!!
        }
        return root
    }
    
    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }
}