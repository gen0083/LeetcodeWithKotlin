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
        val stack: Stack<TreeNode> = Stack()
        var pointer: TreeNode? = root
        stack.push(pointer)
        while (stack.isNotEmpty() || pointer != null) {
            while (pointer != null) {
                val left = pointer.left
                if (left != null && left.`val` >= pointer.`val`) {
                    return false
                }
                stack.push(left)
                pointer = left
            }
            pointer = stack.pop()
            val right = pointer?.right
            if (right != null && right.`val` <= pointer.`val`) {
                return false
            }
            pointer = right
        }
        return true
    }
}