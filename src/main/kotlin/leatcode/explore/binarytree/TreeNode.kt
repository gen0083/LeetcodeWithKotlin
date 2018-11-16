package leatcode.explore.binarytree

import java.util.*

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    
    companion object {
        fun generateTreeNode(intArray: Array<Int?>): TreeNode? {
            if (intArray.isEmpty()) return null
            val root = TreeNode(intArray[0]!!)
            if (intArray.size == 1) return root
            var tmp = ArrayDeque<TreeNode>()
            tmp.add(root)
            loop@ for (i in 1..intArray.lastIndex step 2) {
                val t = tmp.pop()
                if (intArray[i] != null) {
                    val n = TreeNode(intArray[i]!!)
                    t.left = n
                    tmp.add(n)
                }
                if (i + 1 >= intArray.size) break@loop
                if (intArray[i + 1] != null) {
                    val n = TreeNode(intArray[i + 1]!!)
                    t.right = n
                    tmp.add(n)
                }
            }
            return root
        }
    }
}

