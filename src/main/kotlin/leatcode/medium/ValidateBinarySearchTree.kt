package leatcode.medium

import leatcode.explore.binarytree.TreeNode
import java.util.*

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * 与えられたTreeNodeが正しく二分探索木の条件を満たしているかを調べる
 */
class ValidateBinarySearchTree {
    
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        val stack = Stack<TreeNode>()
        var pointer: TreeNode? = root
        var prev: Int? = null
        while (stack.isNotEmpty() || pointer != null) {
            while (pointer != null) {
                stack.push(pointer)
                pointer = pointer.left
            }
            pointer = stack.pop()
            val v = pointer.`val`
            if (prev == null) {
                prev = v
            } else {
                if (v > prev) {
                    prev = v
                } else {
                    return false
                }
            }
            pointer = pointer.right
        }
        return true
    }
}