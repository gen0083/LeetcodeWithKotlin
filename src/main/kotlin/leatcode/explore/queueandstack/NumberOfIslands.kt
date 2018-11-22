package leatcode.explore.queueandstack

import java.util.*

/**
 * https://leetcode.com/explore/featured/card/queue-stack/231/practical-application-queue/1374/
 *
 * 2次元の配列が与えられる
 * 0と1のみが含まれるcharArrayで、1が陸地、0が海を表す
 * 1が隣接しているものは島とみなす
 * この島がいくつ存在するかを調べる
 */
class NumberOfIslands {
    
    // 000
    // 100
    // 001　のように配列が与えられる
    // →をx軸、↓をy軸とすると、配列の指定がy,xとなるので注意
    fun numOfIslands(grid: Array<CharArray>): Int {
        val visited = HashMap<Pair<Int, Int>, Boolean>()
        val queue = LinkedList<Pair<Int, Int>>()
        var count = 0
        for (y in 0 until grid.size) {
            val horizontal = grid[y]
            for (x in 0 until horizontal.size) {
                // 訪問済みならskip
                if (visited.containsKey(x to y)) continue
                // 海の場合はskip
                if (grid[y][x] == '0') {
                    visited[x to y] = true
                    continue
                }
                count++
                queue.offer(x to y)
                while (queue.isNotEmpty()) {
                    val (qx, qy) = queue.poll()
                    // 訪問済みならskip
                    if (visited.containsKey(qx to qy)) continue
                    visited[qx to qy] = true
                    // 海ならskip
                    if (grid[qy][qx] == '0') continue
                    // check up
                    if (qy > 0) queue.offer(qx to qy - 1)
                    // check down
                    if (qy < grid.lastIndex) queue.offer(qx to qy + 1)
                    // check right
                    if (qx < horizontal.lastIndex) queue.offer(qx + 1 to qy)
                    // check left
                    if (qx > 0) queue.offer(qx - 1 to qy)
                }
            }
        }
        return count
    }
}