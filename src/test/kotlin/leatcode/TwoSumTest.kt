package leatcode

import org.amshove.kluent.shouldContainSame
import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertSame

object TwoSumTest : Spek({
    describe("two sum") {
        val sut by memoized { TwoSum() }
        var start: Long = 0L
        
        beforeGroup {
            start = System.currentTimeMillis()
        }
        
        afterGroup {
            val time = System.currentTimeMillis() - start
            println("run $time ms")
        }
        
        it("given array of [2, 7, 15, 11] and target 9 then return [0, 1]") {
            val result = sut.twoSum(intArrayOf(2, 7, 15, 11), 9)
            result shouldEqual intArrayOf(0, 1)
        }
        
        it("givien array of [0, 4, 3, 0] and target 0 then return [0, 3]") {
            val result = sut.twoSum(intArrayOf(0, 4, 3, 0), 0)
            result shouldEqual intArrayOf(0, 3)
        }
        
        it("given array of [-1,-2,-3,-4,-5] and target -8 then return [2, 4]") {
            val result = sut.twoSum(intArrayOf(-1, -2, -3, -4, -5), -8)
            result shouldEqual intArrayOf(2, 4)
        }
        
        it("given array of [3, 2, 4] and target 6 then return [1, 2]") {
            val result = sut.twoSum(intArrayOf(3, 2, 4), 6)
            result shouldEqual intArrayOf(1, 2)
        }
    }
})
