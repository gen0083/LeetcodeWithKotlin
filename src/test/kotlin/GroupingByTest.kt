import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class GroupingByTest: Spek({
    describe("Iterable.groupingBy") {
        val list = listOf(
            Test("hoge", "aaa"),
            Test("fuga", "bbb"),
            Test("bar", "ccc"),
            Test("hoge", "ddd"),
            Test("fuga", "eee"),
            Test("xyz", "fff")
        )
        
        it("aggregate") {
            val result: Map<String, String> = list.groupingBy { it.key }
                .aggregate { key, accumulator, element, first ->
                    if (first) {
                        element.value
                    } else {
                        accumulator + element.value
                    }
                }
            println(result)
        }
        
        it("fold") {
            val result = list.groupingBy { it.key }
                .fold("") {accumulator, element ->
                    accumulator + element.value
                }
            println(result)
        }
        
        it("reduce") {
            val result = list.groupingBy { it.key }
                .reduce { key, accumulator, element ->
                    Test(key, accumulator.value + element.value)
                }
            println(result)
        }
    }
    
    describe("array") {
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7)
        
        it("reduce") {
            val result = array.groupingBy { it % 2 }
                .reduce { key, accumulator, element -> accumulator + element }
            val map = array.groupBy { it % 2 }
            println(result)
        }
    }
})

private data class Test(val key: String, val value: String)