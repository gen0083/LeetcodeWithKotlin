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
    }
})