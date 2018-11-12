import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldEqualTo
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class SubListTest : Spek({
    it("subListのtoIndexは指定したindexを含まない") {
        val list = listOf("a", "b", "c", "d")
        val tmp = list.subList(1, list.lastIndex)
        
        list.size shouldEqualTo 4
        list.lastIndex shouldEqualTo 3
        
        tmp.size shouldEqualTo 2
        tmp shouldEqual listOf("b", "c")
    }
})