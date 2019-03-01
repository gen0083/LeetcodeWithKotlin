package leatcode.explore.queueandstack.stackanddfs

import leatcode.explore.binarytree.TreeNode
import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class BinaryTreeInorderTraversalTest : Spek({
    val sut = BinaryTreeInorderTraversal()
    
    it("[1,null,2,3] return [1,3,2]") {
        val result = sut.inorderTraversal(TreeNode.generateTreeNode(arrayOf(1, null, 2, 3)))
        result shouldEqual listOf(1, 3, 2)
    }
    
    it("[1,2,3,4,5] return [4,2,5,1,3]") {
        val result = sut.inorderTraversal(TreeNode.generateTreeNode(arrayOf(1, 2, 3, 4, 5)))
        result shouldEqual listOf(4, 2, 5, 1, 3)
    }
})