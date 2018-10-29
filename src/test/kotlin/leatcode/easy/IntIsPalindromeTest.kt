package leatcode.easy

import org.amshove.kluent.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class IntIsPalindromeTest : Spek({
    describe("input int that is palindrome?") {
        val sut by memoized { IntIsPalindrome() }
        
        it("input 121 then return true") {
            val result = sut.isPalindrome(121)
            result shouldBe true
        }
        
        it("input -121 then return false") {
            val result = sut.isPalindrome(-121)
            result shouldBe false
        }
        
        it("input 10 then return false") {
            val result = sut.isPalindrome(10)
            result shouldBe false
        }
    }
    
    describe("input int that is palindrome? without converting int to string") {
        val sut by memoized { IntIsPalindrome() }
        
        it("input 121 then return true") {
            val result = sut.isPalindromeWithoutStringConvert(121)
            result shouldBe true
        }
        
        it("input -121 then return false") {
            val result = sut.isPalindromeWithoutStringConvert(-121)
            result shouldBe false
        }
        
        it("input 10 then return false") {
            val result = sut.isPalindromeWithoutStringConvert(10)
            result shouldBe false
        }
    }
})

