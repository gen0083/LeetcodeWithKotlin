package leatcode.explore.queueandstack

import org.amshove.kluent.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class MyCircularQueueTest : Spek({
    it("indexが円環しないケース") {
        val sut = MyCircularQueue(4)
        
        sut.Front() shouldBe -1
        sut.isEmpty() shouldBe true
        
        sut.enQueue(4) shouldBe true
        sut.Front() shouldBe 4
        sut.Rear() shouldBe 4
        sut.isEmpty() shouldBe false
        
        sut.enQueue(10) shouldBe true
        sut.Front() shouldBe 4
        sut.Rear() shouldBe 10
        
        sut.deQueue()
        sut.Front() shouldBe 10
    }
    
    it("arrayがいっぱいになるケース") {
        val sut = MyCircularQueue(2)
        
        sut.isFull() shouldBe false
        
        sut.enQueue(1)
        sut.enQueue(2)
        
        sut.isFull() shouldBe true
        
        sut.enQueue(3) shouldBe false
    }
    
    it("円環するケース") {
        val sut = MyCircularQueue(2)
        
        sut.isEmpty() shouldBe true
        
        sut.enQueue(1)
        sut.enQueue(2)
        sut.deQueue()
        sut.enQueue(3)
        sut.enQueue(4) shouldBe false
        
        sut.Front() shouldBe 2
        sut.Rear() shouldBe 3
        
        sut.isFull() shouldBe true
    }
})