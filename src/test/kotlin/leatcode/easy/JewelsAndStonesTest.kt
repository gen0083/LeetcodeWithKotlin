package leatcode.easy

import org.amshove.kluent.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object JewelsAndStonesTest: Spek({
    describe("Jewels and stones") {
        val sut by memoized { JewelsAndStones() }
        
        it("given J as 'aA' and S as 'aAAbbbb' then return 3") {
            val result = sut.numJewelsInStones("aA", "aAAbbbb")
            result shouldBe 3
        }
        
        it("given J as 'z' and S as 'ZZZ' then return 0") {
            val result = sut.numJewelsInStones("z", "ZZ")
            result shouldBe 0
        }
    }
})

