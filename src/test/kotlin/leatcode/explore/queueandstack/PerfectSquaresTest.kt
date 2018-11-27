package leatcode.explore.queueandstack

import org.amshove.kluent.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class PerfectSquaresTest : Spek({
    val sut by memoized { PerfectSquares() }
    
    it("n=12 then output 3") {
        val result = sut.numSquares(12)
        result shouldBe 3
    }
    
    it("n=13 then output 2") {
        val result = sut.numSquares(13)
        result shouldBe 2
    }
    
    it("n=4 then output 1") {
        val result = sut.numSquares(4)
        result shouldBe 1
    }
})