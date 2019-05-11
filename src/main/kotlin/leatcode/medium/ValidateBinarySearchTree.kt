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
        val list = traverseAllValue(root)
        for (i in 0 until list.lastIndex) {
            if (list[i] >= list[i + 1]) return false
        }
        return true
    }

    private fun traverseAllValue(node: TreeNode?): List<Int> {
        if (node == null) return emptyList()
        val list = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        var pointer: TreeNode? = node
        while (stack.isNotEmpty() || pointer != null) {
            while (pointer != null) {
                stack.push(pointer)
                pointer = pointer.left
            }
            pointer = stack.pop()
            list.add(pointer.`val`)
            pointer = pointer.right
        }
        return list
    }
}