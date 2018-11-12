package leatcode.easy

/**
 * https://leetcode.com/contest/weekly-contest-110/problems/reorder-log-files/
 *
 * 与えられるスペース区切りのログデータ配列を並び替える。
 * ログデータはIDを持ち、IDの後は
 * - lowercaseの文字列(letter-logs)
 * - 数値(digit-logs)
 * の形式で、IDのあとに少なくとも1つの文字・数字を含んでいる。
 *
 * 上記のログ配列を並び替える条件は、
 * - letter-logs → digit-logsの順番に並び替える
 * - letter-logsはID以降の文字列をアルファベット順になるように並び替える
 * - letter-logsはID以降の文字で順番が決定できない場合、IDを用いてアルファベット順になるように並び替える
 * - digit-logsは与えられた順番通りに並べる(並び替えを行わないが、letter-logsの後に出力する)
 *
 * 配列の長さは0以上100以下
 * 各ログの長さは3以上100以下
 * 各ログはIDとその後に文字・数字を持つことが保証されている
 */
class ReorderLogFiles {
    
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val digits = arrayListOf<String>()
        val letters = mutableListOf<Pair<Int, String>>()
        val pattern = "(\\w+)(\\s[0-9]+)+".toPattern()
        for (i in 0 until logs.size) {
            if (pattern.matcher(logs[i]).find()) {
                digits.add(logs[i])
            } else {
                val splited = logs[i].split(" ")
                val tmp = splited.subList(1, splited.size) + splited[0]
                letters.add(i to tmp.joinToString(separator = " "))
            }
        }
        val t = letters.sortedBy { it.second }
            .map { logs[it.first] }
            .toMutableList()
        t.addAll(digits)
        return t.toTypedArray()
    }
}