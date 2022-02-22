import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static crackingiw.MinimalTree.treeBinarizeOrderedArray;

public class BinaryTreePaths {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = treeBinarizeOrderedArray(array);
        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> arrayList = binaryTreePaths(root, "");

        return arrayList;
    }

    private static List<String> binaryTreePaths(TreeNode root, String current) {

        List<String> element = new ArrayList<>();
        if (root == null) {
            return element;
        }

        current = current + root.val;

        if (root.left == null && root.right == null) {
            element.add(current);
            return element;
        }

        current = current + "->";

        element.addAll(binaryTreePaths(root.left, current));
        element.addAll(binaryTreePaths(root.right, current));

        return element;
    }
}
