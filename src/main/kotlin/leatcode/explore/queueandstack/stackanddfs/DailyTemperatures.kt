package leatcode.explore.queueandstack.stackanddfs

/**
 * https://leetcode.com/explore/featured/card/queue-stack/230/usage-stack/1363/
 *
 * 日々の気温のリストが与えられる。
 * 各日の気温より暖かい日が何日後に訪れるかのリストを返すメソッドを実装する。
 * 最後の日に関しては以降のデータがないため必ず0になる。
 * その気温より温かい日がない場合は0を返す。
 */
class DailyTemperatures {
    
    fun dailyTemperatures(T: IntArray): IntArray {
        val out = IntArray(T.size)
        for (i in 0 until T.size) {
            var step = 0
            var exist = false
            for (j in i + 1 until T.size) {
                step++
                if (T[i] < T[j]) {
                    exist = true
                    break
                }
            }
            out[i] = if (exist) step else 0
        }
        return out
    }
}