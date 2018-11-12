package leatcode.easy

import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class ReorderLogFilesTest : Spek({
    describe("Reorder log files") {
        val sut: ReorderLogFiles by memoized { ReorderLogFiles() }
        
        it("letter > digitの並び替えのみ発生するケース") {
            val result =
                sut.reorderLogFiles(arrayOf("a1 1 2 3", "b1 aa bb cc", "c2 3 2 1", "d5 abc"))
            
            result shouldEqual arrayOf("b1 aa bb cc", "d5 abc", "a1 1 2 3", "c2 3 2 1")
        }
        
        it("letter > digitの並び替えおよびletter内の並び替えも必要なケース") {
            val result = sut.reorderLogFiles(
                arrayOf("a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"))
            
            result shouldEqual arrayOf("g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1",
                "zo4 4 7")
        }
        
        it("letter-logsに同じ内容を含むケースでIDが若いほうが先に並ぶ") {
            val result = sut.reorderLogFiles(
                arrayOf("c1 abc def", "a1 9 8 7", "aaa2 aaa zzz", "z11 1 2 3", "aaa1 aaa zzz"))
            
            result shouldEqual arrayOf("aaa1 aaa zzz", "aaa2 aaa zzz", "c1 abc def", "a1 9 8 7",
                "z11 1 2 3")
        }
    }
})