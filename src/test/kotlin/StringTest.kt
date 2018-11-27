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
    
    it("substring using intRange") {
        val str = "0123456789"
        
        val oneToFive = str.substring(1..5)
        println(oneToFive)
        oneToFive shouldEqual "12345"
        
        val oneToOne = str.substring(1..1)
        println(oneToOne)
        oneToOne shouldEqual "1"
        
        val zeroToZero = str.substring(0..0)
        println(zeroToZero)
        zeroToZero shouldEqual "0"
        val zeroUntilZero = str.substring(0 until 0)
        println(zeroUntilZero)
        zeroUntilZero shouldEqual ""
    }
})