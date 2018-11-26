import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldNotBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class StringTest : Spek({
    it("Stringコンストラクタを使うと文字列は同じでも異なるインスタンスになる") {
        val str = "abc"
        val charArray = str.toCharArray()
        val instantiated = String(charArray)
        
        str shouldNotBe instantiated
        str shouldEqual instantiated
    }
    
    it("HashSetで使う場合") {
        val str = "abc"
        val set = HashSet<String>()
        set.add(str)
        
        val charArray = String(str.toCharArray())
        set.contains(charArray) shouldEqual true
    }
})