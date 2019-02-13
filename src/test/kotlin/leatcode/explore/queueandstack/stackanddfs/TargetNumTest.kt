package leatcode.explore.queueandstack.stackanddfs

import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class TargetNumTest : Spek({
    val sut = TargetNum()
    
    it("[1,1,1,1,1] and 3 = 5") {
        val result = sut.findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3)
        result shouldEqual 5
    }
    
    it("[10,3,7,5] and 5 = 2") {
        val result = sut.findTargetSumWays(intArrayOf(10, 3, 7, 5), 5)
        result shouldEqual 2
    }
    
    it("[1] and 1 = 1") {
        val result = sut.findTargetSumWays(intArrayOf(1), 1)
        result shouldEqual 1
    }
    
    it("[1000] and -1000 = 1") {
        val result = sut.findTargetSumWays(intArrayOf(1000), -1000)
        result shouldEqual 1
    }
    
    it("[1,0] and 1 = 2") {
        val result = sut.findTargetSumWays(intArrayOf(1, 0), 1)
        result shouldEqual 2
    }
    
    it("[0,0,0,0,0,0,0,0,1] and 1 = 256") {
        val result = sut.findTargetSumWays(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1), 1)
        result shouldEqual 256
    }
})