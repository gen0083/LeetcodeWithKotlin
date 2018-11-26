@file:Suppress("SimplifyBooleanWithConstants")

import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class CharTest : Spek({
    describe("char operation") {
        it("add char") {
            // 文字コードを加算しているのであって、1+1で2になっているわけではない
            '1' + 1 shouldBe '2'
            '0' + 1 shouldBe '1'
            // そのため'9'+1は:になる
            '9' + 1 shouldBe ':'
        }
        
        it("minus char") {
            '1' - 1 shouldBe '0'
            '9' - 1 shouldBe '8'
            '0' - 1 shouldBe '/'
        }
        
        it("char comparison") {
            ('1' > '0') shouldBe true
            ('9' > '0') shouldBe true
            ('5' >= '5') shouldBe true
            
            ('9' + 1 > '9') shouldBe true
            ('0' - 1 < '0') shouldBe true
        }
    }
    
    describe("char array operation") {
        it("string operation") {
            val str = "0123"
            val array = str.toCharArray()
            array[1] = array[1] + 1
            String(array) shouldEqual "0223"
        }
    }
})