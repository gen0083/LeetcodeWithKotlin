package leatcode.medium

import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class AddTwoNumbersTest : Spek({
    describe("Add two numbers") {
        val sut: AddTwoNumbers by memoized { AddTwoNumbers() }
        
        it("input [2, 4, 3] and [5, 6, 4] then result [7, 0, 8]") {
            val first = makeListNode(intArrayOf(2, 4, 3))
            val second = makeListNode(intArrayOf(5, 6, 4))
            val result = sut.addTwoNumbers(first, second)
            
            convertResult(result) shouldEqual intArrayOf(7, 0, 8)
        }
        
        it("input [9, 9, 9] and [9, 9, 9] then result [8, 9, 9, 1]") {
            val first = makeListNode(intArrayOf(9, 9, 9))
            val second = makeListNode(intArrayOf(9, 9, 9))
            val result = sut.addTwoNumbers(first, second)
            
            convertResult(result) shouldEqual intArrayOf(8, 9, 9, 1)
        }
        
        it("input [0] and [1] then result [1]") {
            val first = makeListNode(intArrayOf(0))
            val second = makeListNode(intArrayOf(1))
            val result = sut.addTwoNumbers(first, second)
            
            convertResult(result) shouldEqual intArrayOf(1)
        }
    }
})

fun makeListNode(array: IntArray): AddTwoNumbers.ListNode {
    val root = AddTwoNumbers.ListNode(array[0])
    var parent = root
    for (i in 1 until array.size) {
        val node = AddTwoNumbers.ListNode(array[i])
        parent.next = node
        parent = node
    }
    return root
}

fun convertResult(node: AddTwoNumbers.ListNode?): IntArray {
    if (node == null) return intArrayOf(0)
    val list = mutableListOf<Int>()
    list.add(node.`val`)
    var target = node!!
    while (target.next != null) {
        target.next?.let {
            list.add(it.`val`)
            target = it
        }
    }
    return list.toIntArray()
}