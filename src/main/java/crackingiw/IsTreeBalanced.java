package crackingiw;

import structures.TreeNode;

import static crackingiw.MinimalTree.treeBinarizeOrderedArray;

public class IsTreeBalanced {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode node = treeBinarizeOrderedArray(array);
        System.out.println(height(node));

        // this runs in o(n*log(n))
        System.out.println(isBalancedNotOptimized(node));

        // this runs in o(n) * o(H) where H is the height of the tree (which is o(log(n) in perfect binary trees))
        // so we moved the * outside the frigging O() -> o(n) * o(log(n)) and this means o(n) because o(log(n)) will be dropped.
        System.out.println(isBalancedOptimized(node));

        TreeNode unbalanced = new TreeNode(10, new TreeNode(10, new TreeNode(10), null), null);
        System.out.println(isBalancedNotOptimized(unbalanced));
        System.out.println(isBalancedOptimized(unbalanced));

    }

    private static boolean isBalancedNotOptimized(TreeNode node) {
        if (node == null) {
            return true;
        }
        Integer leftHeight = height(node.left);
        Integer rightHeight = height(node.right);
        if (Math.abs(rightHeight - leftHeight) > 1) {
            return false;
        }
        return isBalancedNotOptimized(node.left) && isBalancedNotOptimized(node.right);
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private static boolean isBalancedOptimized(TreeNode node) {
        return heightBalanced(node) != Integer.MIN_VALUE;
    }

    private static Integer heightBalanced(TreeNode node) {

        if (node == null) {
            return 0;
        }

        Integer leftHeight = heightBalanced(node.left);
        Integer rightHeight = heightBalanced(node.right);

        if (leftHeight == Integer.MIN_VALUE || rightHeight == Integer.MAX_VALUE) {
            return Integer.MIN_VALUE;
        }
        int diff = Math.abs(rightHeight - leftHeight);
        if (diff > 1) {
            return Integer.MIN_VALUE;
        }

        return Math.max(rightHeight, leftHeight) + 1;
    }

}
