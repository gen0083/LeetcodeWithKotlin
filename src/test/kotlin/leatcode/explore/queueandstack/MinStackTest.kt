package leatcode.explore.queueandstack

import org.amshove.kluent.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class MinStackTest : Spek({
    it("operation") {
        val sut = MinStack()
        
        sut.push(-2)
        sut.push(0)
        sut.push(-3)
        
        sut.getMin() shouldBe -3
        sut.pop()
        sut.top() shouldBe 0
        sut.getMin() shouldBe -2
    }
})