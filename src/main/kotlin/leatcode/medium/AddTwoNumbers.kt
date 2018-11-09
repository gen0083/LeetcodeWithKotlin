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
    
    // 各桁の計算結果を直接計算結果ListNodeのnextに追加していく
    // 最終的にListNodeのroot要素のnextを返せば各桁の計算結果が返せる仕組み
    // rootを1桁目の計算結果にするためには、whileループの中でif文が必要になる
    // (次の計算結果を格納するNextを用意する必要があるが、そのままでは最終ループの段階でもnextを確保してしまうため)
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var t1 = l1
        var t2 = l2
        var carry = 0
        val resultRoot = ListNode()
        var result = resultRoot
        while (t1 != null || t2 != null) {
            val i = t1?.`val` ?: 0
            val j = t2?.`val` ?: 0
            val n = i + j + carry
            result.next = ListNode(n % 10)
            result = result.next!!
            carry = n / 10
            t1 = t1?.next
            t2 = t2?.next
        }
        if (carry > 0) result.next = ListNode(1)
        return resultRoot.next
    }
    
    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }
}