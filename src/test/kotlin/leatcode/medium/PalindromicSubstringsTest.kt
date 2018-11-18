package leatcode.medium

import org.amshove.kluent.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class PalindromicSubstringsTest : Spek({
    val sut by memoized { PalindromicSubstrings() }
    
    it("given abc then return 3") {
        sut.countSubstrings("abc") shouldBe 3
    }
    
    it("given aaa then return 6") {
        sut.countSubstrings("aaa") shouldBe 6
    }
})