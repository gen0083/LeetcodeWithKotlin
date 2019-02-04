package leatcode.explore.queueandstack.stackanddfs

import org.amshove.kluent.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class EvaluateReversePolishNotationTest : Spek({
    val sut = EvaluateReversePolishNotation()
    
    it("input [\"2\", \"1\", \"+\", \"3\", \"*\"] then return 9") {
        val result = sut.evalRPN(arrayOf("2", "1", "+", "3", "*"))
        result shouldBe 9
    }
    
    it("input [\"4\", \"13\", \"5\", \"/\", \"+\"] then return 6") {
        val result = sut.evalRPN(arrayOf("4", "13", "5", "/", "+"))
        result shouldBe 6
    }
    
    it("input [\"10\", \"6\", \"9\", \"3\", \"+\", \"-11\", \"*\", \"/\", \"*\", \"17\", \"+\", \"5\", \"+\"] then return 22") {
        val result = sut.evalRPN(
            arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"))
        result shouldBe 22
    }
})