package leatcode.explore.binarytree

import java.util.*

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
 * https://ja.wikipedia.org/wiki/%E4%BA%8C%E5%88%86%E6%9C%A8
 * http://www-ikn.ist.hokudai.ac.jp/~arim/pub/algo/algo6.pdf
 *
 * BinaryTree(二分木)のpre-order traversal(前順・行きがかり順)
 * 再帰処理orループ処理で全要素探索するには？
 *
 * pre-orderはノードの値をたどった順番に出力する
 * ノードの値を出力→leftへ移動→rightへ移動
 *
 * 再帰はすぐに思いつくが、これをiterativelyにやるのが難しい
 *
 */
class PreorderTraversal {
    
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        if (root == null) return list
        list.add(root.`val`)
        list.addAll(preorderTraversal(root.left))
        list.addAll(preorderTraversal(root.right))
        return list
    }
    
    fun preorderTraversalRecursively(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        if (root == null) return list
        list.add(root.`val`)
        list.addAll(preorderTraversalRecursively(root.left))
        list.addAll(preorderTraversalRecursively(root.right))
        return list
    }
    
    fun preorderTraversalIteratively(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        root ?: return list
        var pointer: TreeNode? = root
        val stack = Stack<TreeNode>()
        while (pointer != null || stack.isNotEmpty()) {
            while (pointer != null) {
                list.add(pointer.`val`)
                stack.push(pointer)
                pointer = pointer.left
            }
            pointer = stack.pop()
            pointer = pointer.right
        }
        return list
    }
}