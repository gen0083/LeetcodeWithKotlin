package leatcode.explore.queueandstack

/**
 * https://leetcode.com/explore/featured/card/queue-stack/228/first-in-first-out-data-structure/1337/
 */
class MyCircularQueue(k: Int) {
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    private val array: Array<Int> = Array(k) { 0 }
    private var head: Int = 0
    private var tail: Int = -1
    private var length = 0
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    fun enQueue(value: Int): Boolean {
        if (isFull()) return false
        tail = plusIndex(tail)
        array[tail] = value
        length++
        return true
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    fun deQueue(): Boolean {
        if (isEmpty()) return false
        head = plusIndex(head)
        length--
        return true
    }
    
    /** Get the front item from the queue. */
    fun Front(): Int {
        if (isEmpty()) return -1
        return array[head]
    }
    
    /** Get the last item from the queue. */
    fun Rear(): Int {
        if (isEmpty()) return -1
        return array[tail]
    }
    
    /** Checks whether the circular queue is empty or not. */
    fun isEmpty(): Boolean {
        return length == 0
    }
    
    /** Checks whether the circular queue is full or not. */
    fun isFull(): Boolean {
        return length == array.size
    }
    
    private fun plusIndex(index: Int): Int {
        var out = index + 1
        if (out >= array.size) out = 0
        return out
    }
}