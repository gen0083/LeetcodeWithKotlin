package leatcode.explore.queueandstack.stackanddfs

import java.util.*

/**
 * https://leetcode.com/explore/featured/card/queue-stack/230/usage-stack/1363/
 * https://leetcode.com/problems/daily-temperatures/
 *
 * 日々の気温のリストが与えられる。
 * 各日の気温より暖かい日が何日後に訪れるかのリストを返すメソッドを実装する。
 * 最後の日に関しては以降のデータがないため必ず0になる。
 * その気温より温かい日がない場合は0を返す。
 *
 * ポイント:
 * 1. 要素は最後尾から先頭に向かって見ていくこと
 * 2. 検索位置の時点における最高気温の順がわかっていればよいこと
 *
 * Stackをどう活かせばいいのかがわからなくて結局自力では二重ループを使う方法しかできなかった
 */
class DailyTemperatures {
    
    fun dailyTemperatures(T: IntArray): IntArray {
        // Stackを使う解法
        // 要素の最後尾から順番に見ていく
        // Stackを要素の最後尾から見ていった場合に、気温が降順になるようにStackにindexが積まれる
        // 途中で低い気温が現れた場合、その要素は無視されるようになっている
        val ans = IntArray(T.size)
        val stack = Stack<Int>()
        for (i in T.size - 1 downTo 0) {
            // 現在調べている気温よりStackの先頭の気温が高くなるまでStackの要素を取り出す
            // 例えば今調べているのが32だとしたら[31, 33, 35]というStackの場合31は不要になる
            // 今調べている要素が32なので、それより以前の日については31よりも32の方が、
            // より高くより近い日になるから31の日が選ばれる余地が無いからである
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop()
            // indexでStackに積むことにより、indexとの差で何日後かを計算できる
            ans[i] = if (stack.isEmpty()) 0 else stack.peek() - i
            stack.push(i)
        }
        return ans
    }
}