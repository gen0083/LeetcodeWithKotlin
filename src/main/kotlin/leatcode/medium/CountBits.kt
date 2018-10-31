package leatcode.medium

/**
 * https://leetcode.com/problems/counting-bits/
 *
 * 入力されたintの値について、0以上入力int値以下の各数値について、2進数でのビット表現を行った際に
 * ビットが立っている個数を配列に入れて返す。
 *
 * 普通にやるだけなら簡単だが(要するに0からnまでカウントアップしていって、各数値でbitが立ってる数をカウントアップする方法)
 * これをO(n)の処理時間で処理できるかがポイント
 *
 * また、組み込み関数を利用することなくできるかどうかもポイント
 */
class CountBits {
    
    val memo = mutableMapOf<Int, Int>()
    
    fun countBits(num: Int): IntArray {
        // 普通にやるのも大変だが・・・Kotlinではbitをカウントする方法があるんだろうか？
        // 1,2,4,8,16,32...と2の自乗で直接表現できる数はビットが1であるここは変わらない
        // あとはこの1,2,4,8,16,32...の組み合わせが何個あるかでビット数を計算すれば良いということになる
        val result = IntArray(num + 1)
        
        // 1は最下位ビットが立ってる状態でこれをmaskとして利用
        // &演算を行ってmaskと一致する=該当ビットが立っているということになる
        // このmaskを1ビットずつ左シフトしていけば各桁のビットの有無が確認できる
        // maskはint値なので、いずれオーバーフローによって0になる
        // 0になったらすべての桁をチェックしたことになるのでループを抜ける
        // もっとも原始的で無駄の多い処理になる
        for (i in 0..num) {
            var count = 0
            var mask = 1
            while (mask != 0) {
                if (i and mask == mask) count++
                mask = mask.shl(1)
            }
            result[i] = count
        }
        return result
    }
}