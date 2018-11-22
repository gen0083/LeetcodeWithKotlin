package leatcode.explore.queueandstack

import org.amshove.kluent.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class NumberOfIslandsTest : Spek({
    val sut = NumberOfIslands()
    
    it("case 1") {
        val result = sut.numOfIslands(
            arrayOf(
                "11110".toCharArray(),
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00000".toCharArray()
            )
        )
        
        result shouldBe 1
    }
    
    it("case 2") {
        val result = sut.numOfIslands(arrayOf(
            "1000".toCharArray(),
            "0000".toCharArray(),
            "0001".toCharArray()
        ))
        
        result shouldBe 2
    }
    
    it("case 3") {
        val result = sut.numOfIslands(arrayOf(
            "11000".toCharArray(),
            "11000".toCharArray(),
            "00100".toCharArray(),
            "00011".toCharArray()
        ))
        
        result shouldBe 3
    }
    
    it("ちょっと複雑なケース") {
        val result = sut.numOfIslands(arrayOf(
            "11100".toCharArray(),
            "10110".toCharArray(),
            "10101".toCharArray(),
            "01011".toCharArray()
        ))
        
        result shouldBe 3
    }
})
