package leatcode.easy

import org.amshove.kluent.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class RobotReturnToOriginTest: Spek({
    describe("robots move started from 0,0 and return 0,0?") {
        val sut by memoized { RobotReturnToOrigin() }
        
        it("move UD then true") {
            val result = sut.judgeCircle("UD")
            result shouldBe true
        }
        
        it("move LL then false") {
            val result = sut.judgeCircle("LL")
            result shouldBe false
        }
    }
})
