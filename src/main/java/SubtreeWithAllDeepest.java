import structures.TreeNode;

public class SubtreeWithAllDeepest {

    /**
     * Return the subTree with the deepest nodes.
     *
     * @param root
     * @return
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        if (root == null) {
            return null;
        }

        int depthLeft = 1;
        int depthRight = 1;

        depthLeft += traverse(root.left);
        depthRight += traverse(root.right);

        if (depthLeft == depthRight) {
            return root;
        } else if (depthLeft > depthRight) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }

    }

    private int traverse(TreeNode node) {
        int depth = 0;
        if (node != null) {
            depth += Math.max(traverse(node.left), traverse(node.right));
        }
        return depth;
    }

}
