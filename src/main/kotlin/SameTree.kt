/**
    Given the roots of two binary trees p and q, write a function to check if they are the same or not.
    Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
class SolutionSameTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null || q == null) return p == q
        return p.`val` == q.`val` && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }

    fun isSymmetric(root: TreeNode?): Boolean {
        if(root?.left == null && root?.right == null) return true
        return isSymmetricTree(root?.left, root?.right)
    }

    fun isSymmetricTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null || q == null) return p == q

        return p.`val` == q.`val` && isSameTree(p.left, q.right) && isSameTree(p.right, q.left)
    }
}