import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldEqualTo
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class CompareTest : Spek({
    describe("Stringの比較") {
        it("一文字の比較") {
            val a = "a"
            val b = "b"
            
            a.compareTo(b) shouldEqualTo -1
        }
        
        it("2文字の比較 同じ値") {
            val a = "aa"
            val b = "aa"
            
            a.compareTo(b) shouldEqualTo 0
        }
        
        it("2文字の比較 後者が若い") {
            val a = "ab"
            val b = "aa"
            
            a.compareTo(b) shouldEqualTo 1
        }
    }
    
    describe("sortの確認") {
        it("アルファベット2文字の比較") {
            val list = arrayOf("aa", "ac", "ab")
            
            list.sortedBy { it }
                .toTypedArray() shouldEqual arrayOf("aa", "ab", "ac")
        }
        
        it("空白を含む文字列の比較") {
            val list = arrayOf("a b c", "abc aa", "aac bb")
            list.sortedBy { it }
                .toTypedArray() shouldEqual arrayOf("a b c", "aac bb", "abc aa")
        }
        
        it("空白後のアルファベットだけが違うケース") {
            val list = arrayOf("a acd", "a ab", "a aa")
            
            list.sortedBy { it }
                .toTypedArray() shouldEqual arrayOf("a aa", "a ab", "a acd")
        }
    }
})