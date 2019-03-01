package leatcode.explore.queueandstack.stackanddfs

import leatcode.explore.binarytree.TreeNode
import java.util.*

/**
 * https://leetcode.com/explore/featured/card/queue-stack/232/practical-application-stack/1383/
 *
 * Treeの巡回ロジックは全部同じ
 * Treeの値をどのタイミングで出力するのかによってinorder traversalやpreorder traversalなどが区別される
 *
 * Inorder traversalはノードを枝葉まで降りてからあとは通った順番に出力する
 * Stackを利用する場合、とにかくpointerがnullになるまでleftを掘り進みながらstackにpush
 * pointerがnullになったらループを抜けてstackからpopする
 * popした値はTreeの左末端になるので、そのノードの右にポインタを動かす
 * その後は再度pointerがnullになるまでleftを掘り進む...以下同じ
 *
 * 久しぶりにやると
 * - ループ継続の条件をどうすればよいのか
 * - 右ノードに移動するのは度のタイミングか
 *
 * などがわからなくなってしまう
 */
class BinaryTreeInorderTraversal {
    
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        root ?: return list
        var t: TreeNode? = root
        while (t != null || stack.isNotEmpty()) {
            while (t != null) {
                stack.push(t)
                t = t.left
            }
            t = stack.pop()
            list.add(t.`val`)
            t = t.right
        }
        return list
    }
}