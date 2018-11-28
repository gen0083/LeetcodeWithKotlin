package leatcode.explore.queueandstack.stackanddfs

import org.amshove.kluent.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class ValidParenthesesTest : Spek({
    val sut = ValidParentheses()
    
    it("() = true") {
        sut.isValid("()") shouldBe true
    }
    
    it("()[]{} = true") {
        sut.isValid("()[]{}") shouldBe true
    }
    
    it("(] = false") {
        sut.isValid("(]") shouldBe false
    }
    
    it("([)] = false") {
        sut.isValid("([)]") shouldBe false
    }
    
    it("{[]} = true") {
        sut.isValid("{[]}") shouldBe true
    }
    
    it("empty = valid") {
        sut.isValid("") shouldBe true
    }
    
    it("] = false") {
        sut.isValid("]") shouldBe false
    }
    
    it("[ = false (must be closed)") {
        sut.isValid("[") shouldBe false
    }
})