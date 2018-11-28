package leatcode.explore.queueandstack

class MinStack {
    /** initialize your data structure here. */
    private val data = arrayListOf<Int>()
    
    fun push(x: Int) {
        data.add(x)
    }
    
    fun pop() {
        if (data.isNotEmpty()) data.removeAt(data.size - 1)
    }
    
    fun top(): Int {
        return data.last()
    }
    
    fun getMin(): Int {
        return data.min() ?: 0
    }
    
}