package leatcode.explore.binarytree

import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldNotBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class TreeNodeTest : Spek({
    describe("arrayからTreeNodeに変換する") {
        it("1, null, 2, 3の場合") {
            val result = TreeNode.generateTreeNode(arrayOf(1, null, 2, 3))
            
            result shouldNotBe null
            val root = result!!
            root.`val` shouldBe 1
            root.left shouldBe null
            
            val right = root.right!!
            right.`val` shouldBe 2
            right.left shouldNotBe null
            right.right shouldBe null
            
            val grandChild = right.left!!
            grandChild.`val` shouldBe 3
        }
        
        it("1, 2, 3の場合") {
            val result = TreeNode.generateTreeNode(arrayOf(1, 2, 3))
            
            println(result)
            result shouldNotBe null
            val root = result!!
            
            val left = root.left!!
            left.`val` shouldBe 2
            
            val right = root.right!!
            right.`val` shouldBe 3
        }
        
        it("1, 3, 5, 6, 9, null, 2の場合") {
            val result = TreeNode.generateTreeNode(arrayOf(1, 3, 5, 6, 9, null, 2))
            
            val root = result!!
            root.`val` shouldBe 1
            
            root.left!!.`val` shouldBe 3
            root.right!!.`val` shouldBe 5
            
            root.left!!.left!!.`val` shouldBe 6
            root.left!!.right!!.`val` shouldBe 9
            
            root.right!!.left shouldBe null
            root.right!!.right!!.`val` shouldBe 2
        }
    }
})

