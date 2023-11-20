fun lowestCommonAncestor(root: Solution.TreeNode?, p: Solution.TreeNode?, q: Solution.TreeNode?): Solution.TreeNode? {
    if (root == null || root == p || root == q) {
        return root
    }

    val l = lowestCommonAncestor(root.left, p, q)
    val r = lowestCommonAncestor(root.right, p, q)

    if (l != null && r != null) {
        return root
    }

    return l ?: r
}
