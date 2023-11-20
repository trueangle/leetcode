/**
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 */
class Solution {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        traverse(root, result)
        return result
    }

    fun traverse(root: TreeNode?, list: MutableList<Int>) {
        if (root != null) {
            traverse(root.left, list)
            list.add(root.`val`)
            traverse(root.right, list)
        }
    }
}