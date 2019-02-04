package leatcode.medium

import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class GenerateParenthesesTest : Spek({
    val sut = GenerateParentheses()
    
    it("n=-1 then empty") {
        val result = sut.generateParenthesis(-1)
        result shouldEqual emptyList()
    }
    
    it("n=0 then empty") {
        val result = sut.generateParenthesis(0)
        result shouldEqual emptyList()
    }
    
    it("n=1 then ()") {
        val result = sut.generateParenthesis(1)
        result shouldEqual listOf("()")
    }
    
    it("n=2 then (()),()()") {
        val result = sut.generateParenthesis(2)
        result shouldEqual listOf("(())", "()()")
    }
    
    it("n=3 then ((())),(()()),(())(),()(()),()()()") {
        val result = sut.generateParenthesis(3)
        result shouldEqual listOf("((()))", "(()())", "(())()", "()(())", "()()()")
    }
    
    it("case n=4") {
        val result = sut.generateParenthesis(4)
        result shouldEqual listOf("(((())))", "((()()))", "((())())", "((()))()", "(()(()))",
            "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()",
            "()()(())", "()()()()")
    }
})