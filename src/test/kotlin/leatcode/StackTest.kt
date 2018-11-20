package leatcode

import org.amshove.kluent.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it
import java.util.*

class StackTest : Spek({
    it("stack can contain null value") {
        val stack = Stack<String?>()
        stack.push("one")
        stack.push("two")
        stack.push(null)
        stack.push("four")
        
        stack.pop() shouldBe "four"
        stack.pop() shouldBe null
        stack.pop() shouldBe "two"
    }
})