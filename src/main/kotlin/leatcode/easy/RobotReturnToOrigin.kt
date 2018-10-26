package leatcode.easy

/**
 * https://leetcode.com/problems/robot-return-to-origin/
 *
 * 2次元平面上、0,0を原点としてRobotを移動させる
 * 移動指示は文字列でU up, D down, L left, R rightを意味する
 * Robotには向きは存在しないので、LLと移動したらそれは左に2座標分移動することを意味する
 * 移動の結果、原点0,0に戻った場合trueを返す、それ以外はfalse
 */
class RobotReturnToOrigin {
    fun judgeCircle(moves: String): Boolean {
        val map = moves.groupingBy { it }.eachCount()
        return map['U'] == map['D'] && map['L'] == map['R']
    }
}
