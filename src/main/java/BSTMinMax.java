import structures.TreeNode;

public class BSTMinMax {

    public int rangeSumBST(TreeNode root, int low, int high) {
        return traverse(root, low, high);
    }

    public int traverse(TreeNode root, int low, int high) {
        int sum = 0;
        if (root.val > low && root.left != null) {
            sum += traverse(root.left, low, high);
        }
        if (root.val < high && root.right != null) {
            sum += traverse(root.right, low, high);
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        return sum;
    }

    public static void main(String[] args) {

        BSTMinMax b = new BSTMinMax();

        TreeNode root = new TreeNode(10,

                new TreeNode(5
                        , new TreeNode(3)
                        , new TreeNode(7)),

                new TreeNode(15, null, new TreeNode(18)));

        int a = b.rangeSumBST(root, 7, 15);
        System.out.println(a);
    }
}
