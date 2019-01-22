package leatcode.explore.queueandstack.stackanddfs

import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class DailyTemperaturesTest : Spek({
    
    val sut = DailyTemperatures()
    
    it("T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0]") {
        val result = sut.dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73))
        result shouldEqual intArrayOf(1, 1, 4, 2, 1, 1, 0, 0)
    }
})