import structures.TreeNode;

public class IncreasingOrderSearchThree {

    private static TreeNode curr = new TreeNode();

    /**
     * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree,
     * and every node has no left child and only one right child.
     */
    public static TreeNode increasingBST(TreeNode root) {

        TreeNode ans = curr;
        rearrangeNode(root);
        return ans.right;

    }

    private static void rearrangeNode(TreeNode node) {

        if (node != null) {

            rearrangeNode(node.left);

            node.left = null;

            // got it...
            curr.right = node;
            curr = node;

            rearrangeNode(node.right);

        }

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10,

                new TreeNode(5),

                new TreeNode(15));

        root = increasingBST(root);

        printNode(root);
    }

    private static void printNode(TreeNode root) {

        if (root != null) {
            System.out.println(root.val);
            printNode(root.left);
            printNode(root.right);
        }

    }
}
