package leatcode.medium

import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class CountBitsTest : Spek({
    describe("count bits") {
        val sut by memoized { CountBits() }
        
        it("input 2 return [0, 1, 1]") {
            val i = 4322
            println()
            
            val result = sut.countBits(2)
            result shouldEqual intArrayOf(0, 1, 1)
        }
        
        it("input 5 return [0, 1, 1, 2, 1, 2]") {
            val result = sut.countBits(5)
            result shouldEqual intArrayOf(0, 1, 1, 2, 1, 2)
        }
    }
})
