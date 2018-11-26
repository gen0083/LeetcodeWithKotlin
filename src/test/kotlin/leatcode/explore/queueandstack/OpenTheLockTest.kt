package leatcode.explore.queueandstack

import org.amshove.kluent.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class OpenTheLockTest : Spek({
    val sut by memoized { OpenTheLock() }
    
    it("deadends = [\"0201\",\"0101\",\"0102\",\"1212\",\"2002\"], target = \"0202\" = 6") {
        val result = sut.openLock(arrayOf("0201", "0101", "0102", "1212", "2002"), "0202")
        result shouldBe 6
    }
    
    it("deadends = [\"8888\"], target = \"0009\" = 1") {
        val result = sut.openLock(arrayOf("8888"), "0009")
        result shouldBe 1
    }
    
    it("deadends = [\"8887\",\"8889\",\"8878\",\"8898\",\"8788\",\"8988\",\"7888\",\"9888\"], target = \"8888\" = -1") {
        val result =
            sut.openLock(arrayOf("8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"),
                "8888")
        result shouldBe -1
    }
    
    it("deadends = [\"0000\"], target = \"8888\" = -1") {
        val result = sut.openLock(arrayOf("0000"), "8888")
        result shouldBe -1
    }
})