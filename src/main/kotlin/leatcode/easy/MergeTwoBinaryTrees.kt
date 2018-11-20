package leatcode.easy

import leatcode.explore.binarytree.TreeNode
import java.util.*

/**
 * P617: https://leetcode.com/problems/merge-two-binary-trees/
 *
 * 与えられた2つの二分木を合成する
 * 同じ位置に存在するノードは加算し、片方に存在しない部分にあるノードはそのままくっつける感じ
 *
 */
class MergeTwoBinaryTrees {
    
    fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
        if (t1 == null && t2 == null) return null
        val root: TreeNode? = t1 ?: TreeNode(0)
        var p1 = root
        var p2 = t2
        val stack1 = Stack<TreeNode?>()
        val stack2 = Stack<TreeNode?>()
        while (p1 != null || p2 != null || stack1.isNotEmpty() || stack2.isNotEmpty()) {
            while (p1 != null || p2 != null) {
                if (p1 == null) {
                    p1 = TreeNode(p2?.`val` ?: 0)
                } else {
                    p1.`val` = p1.`val` + (p2?.`val` ?: 0)
                }
                if (p1.left == null && p2?.left != null) {
                    p1.left = TreeNode(0)
                }
                stack1.push(p1)
                p1 = p1?.left
                stack2.push(p2)
                p2 = p2?.left
            }
            p1 = stack1.pop()
            p2 = stack2.pop()
            if (p1 != null && p1.right == null && p2?.right != null) {
                p1.right = TreeNode(0)
            }
            p1 = p1?.right
            p2 = p2?.right
        }
        return root
    }
}