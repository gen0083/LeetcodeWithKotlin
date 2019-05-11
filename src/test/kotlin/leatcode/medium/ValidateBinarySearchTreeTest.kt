package leatcode.medium

import leatcode.explore.binarytree.TreeNode
import org.amshove.kluent.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class ValidateBinarySearchTreeTest : Spek({
    val sut = ValidateBinarySearchTree()

    it("[] true") {
        val result = sut.isValidBST(null)

        result shouldBe true
    }

    it("[0] true") {
        val result = sut.isValidBST(TreeNode.generateTreeNode(arrayOf(0)))

        result shouldBe true
    }

    it("[0, -1] true") {
        val result = sut.isValidBST(TreeNode.generateTreeNode(arrayOf(0, -1)))

        result shouldBe true
    }

    it("[-2147483648] true") {
        val result = sut.isValidBST(TreeNode.generateTreeNode(arrayOf(-2147483648)))

        result shouldBe true
    }
    
    it("[2,1,3] true") {
        val result = sut.isValidBST(TreeNode.generateTreeNode(arrayOf(2, 1, 3)))
        
        result shouldBe true
    }
    
    it("[5,1,4,null,null,3,6] false") {
        val result = sut.isValidBST(TreeNode.generateTreeNode(arrayOf(5, 1, 4, null, null, 3, 6)))
        
        result shouldBe false
    }
    
    it("[10,5,15,null,null,6,20] false") {
        val result =
            sut.isValidBST(TreeNode.generateTreeNode(arrayOf(10, 5, 15, null, null, 6, 20)))
        // 15のこの枝だけ見るとleftが6で正しいが、ルートは10で10より小さい6がrightノードに存在しているのがアウト
        // 単に巡回時にleftが大きい場合にfalseにする、rightに移動するときにrightが小さかったらfalseにするという
        // ロジックでは漏れが生まれる
        
        result shouldBe false
    }
})