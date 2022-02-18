package crackingiw;

import structures.Node;
import structures.TreeNode;

public class MinimalTree {

    // 4.2 given a sorted (increasing order) array with unique integer elements,
    // write an algorithm to create a binary search tree with minimal height.

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode node = treeBinarizeOrderedArray(array);
        System.out.println(node.toString());
    }

    public static TreeNode treeBinarizeOrderedArray(int[] array) {

        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("array is not valid");
        }
        if (array.length == 1) {
            return new TreeNode(array[0]);
        }
        return treeBinarizeOrderedArray(array, 0, array.length - 1);
    }

    private static TreeNode treeBinarizeOrderedArray(int[] array, int start, int end) {

        int diffPosition = end - start;
        if (diffPosition < 0) {
            return null;
        }
        if (diffPosition == 0) {
            return new TreeNode(array[start]);
        } else {
            int half = diffPosition / 2 + start;
            TreeNode node = new TreeNode(array[half]);
            node.left = treeBinarizeOrderedArray(array, start, half - 1);
            node.right = treeBinarizeOrderedArray(array, half + 1, end);
            return node;
        }
    }

    private static TreeNode correctSolution(int[] array, int start, int end) {
        if (end < start) {
            return null;
        } else {
            int half = (start + end) / 2;
            TreeNode node = new TreeNode(array[half]);
            node.left = correctSolution(array, start, half - 1);
            node.right = correctSolution(array, half + 1, end);
            return node;
        }
    }

}
