package leatcode.explore.queueandstack.stackanddfs

import java.util.*
import kotlin.collections.HashSet

class NumberOfIslandsDFS {
    /**
     * 0が海、1が島を表す2次元配列が与えられる
     *   x ->
     * y 00010
     * | 11000
     * v 00010
     *
     * 四隅は海として扱う
     *
     */
    fun numOfIslands(grid: Array<CharArray>): Int {
        var count = 0
        val stack = Stack<Pair<Int, Int>>()
        val visited = HashSet<Pair<Int, Int>>()
        for (y in 0 until grid.size) {
            val line = grid[y]
            for (x in 0 until line.size) {
                if (visited.contains(y to x)) continue
                if (grid[y][x] == '0') continue
                count++
                stack.push(y to x)
                while (stack.isNotEmpty()) {
                    val (sy, sx) = stack.pop()
                    if (visited.contains(sy to sx)) continue
                    visited.add(sy to sx)
                    if (grid[sy][sx] == '0') continue
                    if (sx > 0) stack.push(sy to sx - 1)
                    if (sx < line.size - 1) stack.push(sy to sx + 1)
                    if (sy > 0) stack.push(sy - 1 to sx)
                    if (sy < grid.size - 1) stack.push(sy + 1 to sx)
                }
            }
        }
        return count
    }
}