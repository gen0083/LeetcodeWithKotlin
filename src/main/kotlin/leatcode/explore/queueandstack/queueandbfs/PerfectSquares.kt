package leatcode.explore.queueandstack.queueandbfs

import java.util.*
import kotlin.collections.HashSet

/**
 * https://leetcode.com/explore/featured/card/queue-stack/231/practical-application-queue/1371/
 *
 * 与えられるnについて、平方数の合計でその数値を表そうとしたときに、最低いくつの平方数が必要になるかを返す
 * 平方数とは、nの自乗で表される数値のこと
 * 1^2=1, 2^2=4, 3^2=9, 4^2=16,....
 */
class PerfectSquares {
    
    fun numSquares(n: Int): Int {
        var count = 0
        // 取得可能な平方数のリストを作成
        val squares = mutableListOf<Int>()
        var t = 1
        var i = 1
        while (t <= n) {
            squares.add(t)
            i++
            t = i * i
        }
        
        val computed = HashSet<Int>()
        computed.add(n)
        val remains = LinkedList<Int>()
        remains.offer(n)
        while (remains.isNotEmpty()) {
            var size = remains.size
            count++
            while (size > 0) {
                val remain = remains.poll()
                size--
                for (s in squares) {
                    val sub = remain - s
                    if (sub == 0) return count
                    if (sub < 0) continue
                    if (computed.contains(sub)) continue
                    remains.offer(sub)
                    computed.add(sub)
                }
            }
        }
        
        return count
    }
}