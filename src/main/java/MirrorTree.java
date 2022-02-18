import crackingiw.MinimalTree;
import structures.TreeNode;
import structures.TreeNodeLevel;

import java.util.ArrayDeque;
import java.util.Queue;

public class MirrorTree {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode node = MinimalTree.treeBinarizeOrderedArray(array);
        printLevel(node);
        mirrorNode(node);
        printLevel(node);

    }

    private static TreeNodeLevel convertToLevelNode(TreeNode node, int level) {
        if (node == null) {
            return null;
        }
        TreeNodeLevel levelNode = new TreeNodeLevel(node.val);
        levelNode.level = level++;
        levelNode.right = convertToLevelNode(node.right, level);
        levelNode.left = convertToLevelNode(node.left, level);
        return levelNode;
    }

    private static void printLevel(TreeNode node) {
        TreeNodeLevel levelNode = convertToLevelNode(node, 0);
        Queue<TreeNodeLevel> queueNode = new ArrayDeque<>();
        queueNode.add(levelNode);
        while (!queueNode.isEmpty()) {
            TreeNodeLevel loopNode = queueNode.remove();
            System.out.println(loopNode.level + " - " + loopNode.val);
            if (loopNode.left != null)
                queueNode.add(loopNode.left);
            if (loopNode.right != null)
                queueNode.add(loopNode.right);
        }
    }

    private static void mirrorNode(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode rightNode = node.right;
        node.right = node.left;
        node.left = rightNode;
        mirrorNode(node.right);
        mirrorNode(node.left);
    }

}
