package leatcode.easy

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // https://leetcode.com/problems/two-sum/solution/
        // 解法
        // 1. 愚直に全件探索する（forを使って二重ループで組み合わせをチェックする）
        // 　　計算量O(n^2)、メモリ空間O(1)というのは、2重ループで探索するので要素数の自乗分計算する必要がある
        // 　　一方で、渡される要素数以外に新たに変数を確保しないので、必要なメモリ空間O(1)はとなる
        // 2. HashMapを利用する（計算量O(n), メモリスペースO(n)）
        // 　　別にHashMapでなくてもいいのだが、O(1)で要素を取得できる手法を利用する
        // 　　要素数分ループするだけですむ（要素それぞれについて、targetとの差異を求めてその差異に該当する要素をO(1)で取得すれば住むので）
        // 　　一方、渡された要素を新たにHashMapに変換して確保する必要があるため、メモリは余計に要素数分必要になる
        // 3. HashMapの確保と同時に探索も同時実行する
        // 　　2の方法ではO(n)のループを二回回す必要があるのでそれをさらに省略した形
        // 　　要素の先頭から、targetとの差異を計算→HashMapに差に該当するものがあるかチェック→なければHashMapに要素を確保→というループで探索を行う
        // 　　判定式が上記2つとはちょっと違って工夫必要だが、もっともループ数が少なくて住む
        val map = nums.mapIndexed { index, i -> i to index }.toMap()
        for (i in nums.indices) {
            val remain = target - nums[i]
            if (map.containsKey(remain)) {
                if (map[remain] != i)
                return intArrayOf(i, map.get(remain)!!)
            }
        }
        throw NoSuchElementException("solution dose not exist")
    }
}