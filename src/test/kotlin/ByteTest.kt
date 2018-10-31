import org.amshove.kluent.shouldEqualTo
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class ByteTest : Spek({
    describe("shift test") {
        it("shift right") {
            val i = 423
            i.and(1) shouldEqualTo 1
            
            val after = i.shr(1).shl(1)
            println(after)
            after.and(1) shouldEqualTo 0
        }
        
        it("1 shift left looping it become 0 at the end") {
            var i = 1
            while (i != 0) {
                i = i.shl(1)
                println(i)
            }
        }
    
        it("最大桁部分にビットが立っているbyteを右シフトしていくと0になるのか") {
            var i: Int = 0x80000000.toInt()
            println(i)
            while (i != 0) {
                // shrを使うと最上位ビットが符号(+/-)として認識される
                // intで0x80000000は-2147483648であり、最上位ビットはマイナスを表す
                // これをshrで右シフトすると、次は0x90000000となりシフトの結果つめられるのは符号と同じビットとなる
                // つまり1がつめられるので、わかりやすく書くと0b1000をshrすると0b1100になる
                // ushrを使うと符号を無視して0でつめるので、0b1000→0b0100となる
                i = i.ushr(1)
                println(i)
            }
        }
    
        it("特定のビットをゼロにする") {
            // maskをinv()で反転させたものとのandをとればよい
            var i = 3
            3 and 1.inv() shouldEqualTo 2
            0b0110 and 0b0010.inv() shouldEqualTo 0b0100
        }
    }
    
    describe("ビット演算子") {
        it("and演算子") {
            // ともに1の場合のみ1を返す
            0b0110 and 0b0010 shouldEqualTo 0b0010
            0b0110 and 0b1001 shouldEqualTo 0b0000
            0b0110 and 0b1111 shouldEqualTo 0b0110
        }
        
        it("or演算子") {
            // どちらかが1なら1を返す
            0b0110 or 0b0010 shouldEqualTo 0b0110
            0b0110 or 0b1001 shouldEqualTo 0b1111
            0b0110 or 0b1111 shouldEqualTo 0b1111
        }
        
        it("xor演算子") {
            // xorはビットが異なるときのみ1を返す0と0 もしくは 1と1 のときに0になる
            0b0110 xor 0b0010 shouldEqualTo 0b0100
            0b0110 xor 0b1001 shouldEqualTo 0b1111
            0b0110 xor 0b1111 shouldEqualTo 0b1001
        }
        
        it("inv()") {
            // inv()はビットの反転、0は1に1は0に
            // Intの値なので32ビットで、これまで無視していた部分が全部1になるので0xffff...となっている
            0b0110.inv() shouldEqualTo 0xfffffff9.toInt()
        }
    }
})