package leatcode.easy

import leatcode.explore.binarytree.TreeNode
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldNotBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class MergeTwoBinaryTreesTest : Spek({
    val sut by memoized { MergeTwoBinaryTrees() }
    
    it("case [1,3,2,5] merged with [2,1,3,null,4,null,7]") {
        val result = sut.mergeTrees(
            TreeNode.generateTreeNode(arrayOf(1, 3, 2, 5)),
            TreeNode.generateTreeNode(arrayOf(2, 1, 3, null, 4, null, 7))
        )
        
        result shouldBe null
    }
    
    it("case [1] merged [1, 2]") {
        val result = sut.mergeTrees(
            TreeNode.generateTreeNode(arrayOf(1)),
            TreeNode.generateTreeNode(arrayOf(1, 2))
        )
        
        result shouldBe null
    }
    
    it("case [] merged [1]") {
        val result = sut.mergeTrees(
            TreeNode.generateTreeNode(arrayOf()),
            TreeNode.generateTreeNode(arrayOf(1))
        )
        
        result shouldNotBe null
        result?.`val` shouldBe 1
    }
    
    it("case [] merged [] then return null") {
        val result = sut.mergeTrees(
            TreeNode.generateTreeNode(arrayOf()),
            TreeNode.generateTreeNode(arrayOf())
        )
        
        result shouldBe null
    }
})