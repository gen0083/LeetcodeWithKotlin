package leatcode.easy

import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class NextGreaterElement1Test : Spek({
    val sut = NextGreaterElement1()
    
    it("[4,1,2] and [1,3,4,2] then [-1,3,-1]") {
        val result = sut.nextGreaterElement(intArrayOf(4, 1, 2), intArrayOf(1, 3, 4, 2))
        result shouldEqual intArrayOf(-1, 3, -1)
    }
})