package leatcode.explore.binarytree

import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class PreorderTraversalTest : Spek({
    val sut = PreorderTraversal()
    
    describe("再帰処理による解法") {
        it("1, null, 2, 3のケース") {
            val node = TreeNode.generateTreeNode(arrayOf(1, null, 2, 3))
            val result = sut.preorderTraversalRecursively(node)
            
            result shouldEqual listOf(1, 2, 3)
        }
        
        it("1, 3, 5, 6, 9, null, 2のケース") {
            val node = TreeNode.generateTreeNode(arrayOf(1, 3, 5, 6, 9, null, 2))
            val result = sut.preorderTraversalRecursively(node)
            
            result shouldEqual listOf(1, 3, 6, 9, 5, 2)
        }
    }
    
    describe("ループ処理による解法") {
        it("1, null, 2, 3のケース") {
            val node = TreeNode.generateTreeNode(arrayOf(1, null, 2, 3))
            val result = sut.preorderTraversalIteratively(node)
        
            result shouldEqual listOf(1, 2, 3)
        }
    
        it("1, 3, 5, 6, 9, null, 2のケース") {
            val node = TreeNode.generateTreeNode(arrayOf(1, 3, 5, 6, 9, null, 2))
            val result = sut.preorderTraversalIteratively(node)
        
            result shouldEqual listOf(1, 3, 6, 9, 5, 2)
        }
    }
})
