import structures.TreeNode;

public class MaxiumDeptBinaryTree {

    /**
     * Given the root of a binary tree, return its maximum depth.
     * <p>
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     */

    public int maxDepth(TreeNode root) {
        return traverse(root);
    }

    private int traverse(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = 1 + traverse(root.left);
        int right = 1 + traverse(root.right);

        return Math.max(left, right);

    }


}
