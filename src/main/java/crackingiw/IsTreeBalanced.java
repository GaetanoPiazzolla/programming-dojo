package crackingiw;

import structures.TreeNode;

import static crackingiw.MinimalTree.treeBinarizeOrderedArray;

public class IsTreeBalanced {


    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode node = treeBinarizeOrderedArray(array);
        System.out.println(height(node));
        System.out.println(isBalanced(node));

        TreeNode unbalanced = new TreeNode(10, new TreeNode(10, new TreeNode(10), null), null);
        System.out.println(isBalanced(unbalanced));
    }

    // TODO isBalanced and height should be collapsed in the same method, so that we can cut some calls.
    // TODO this runs in o(n*log(n)), but why?
    private static boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        Integer leftHeight = height(node.left);
        Integer rightHeight = height(node.right);
        if (Math.abs(rightHeight - leftHeight) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    public static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

}
