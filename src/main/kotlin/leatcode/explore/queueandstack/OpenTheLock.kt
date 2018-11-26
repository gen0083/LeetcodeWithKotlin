package leatcode.explore.queueandstack

import java.util.*

class OpenTheLock {
    fun openLock(deadends: Array<String>, target: String): Int {
        if (deadends.contains("0000")) return -1
        val visited = HashSet<String>()
        visited.addAll(deadends + target)
        var step = 0
        val queue = LinkedList<List<String>>()
        queue.add(listOf(target))
        while (queue.isNotEmpty()) {
            val list = mutableListOf<String>()
            step++
            val patterns = queue.poll()
            for (pattern in patterns) {
                for (i in 0..7) {
                    val array = pattern.toCharArray()
                    val index = i / 2
                    val newChar = if (i % 2 == 0) {
                        // forward
                        turnForward(array[index])
                    } else {
                        // reverse
                        turnReverse(array[index])
                    }
                    array[index] = newChar
                    val turned = String(array)
                    // indexの一のcharのみ書き換える
                    // visitedに存在しないならlistに追加
                    if (turned == "0000") return step
                    if (visited.contains(turned)) continue
                    visited.add(turned)
                    list.add(turned)
                    // visitedに追加
                    // 書き換えた結果が0000ならreturn step
                }
            }
            if (list.isNotEmpty()) queue.offer(list)
        }
        return -1
    }
    
    private fun turnForward(slot: Char): Char {
        val result = slot + 1
        return if (result > '9') '0' else result
    }
    
    private fun turnReverse(slot: Char): Char {
        val result = slot - 1
        return if (result < '0') '9' else result
    }
}