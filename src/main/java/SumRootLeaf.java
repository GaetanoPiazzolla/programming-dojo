import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumRootLeaf {

    /**
     * You are given the root of a binary tree containing digits from 0 to 9 only.
     * Each root-to-leaf path in the tree represents a number.
     * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
     * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
     * A leaf node is a node with no children.
     */
    public int sumNumbers(TreeNode root) {
        List<String> paths = new ArrayList<>();
        calculatePaths(root, paths, "");
        return paths.stream().map(Integer::parseInt).reduce(0, Integer::sum);
    }

    private void calculatePaths(TreeNode node, List<String> paths, String currentPath) {
        currentPath+=node.val;
        if(node.left == null && node.right == null){
            paths.add(currentPath);
            return;
        }
        if(node.left != null)
            calculatePaths(node.left, paths, currentPath);
        if(node.right != null)
            calculatePaths(node.right, paths, currentPath);
    }

}
