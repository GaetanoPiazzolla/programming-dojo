package crackingiw;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static crackingiw.MinimalTree.treeBinarizeOrderedArray;

public class IsTreeBinarySearch {

    // 4.5. Implement a function to check if a binary tree is a binary search tree

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = treeBinarizeOrderedArray(array);

        System.out.println(isTreeBinarySearch(root, null, null));

        List<Integer> list = getList(root);
        System.out.println(isListOrdered(list));

    }

    private static boolean isListOrdered(List<Integer> list) {
        Integer min = list.get(0);
        for (Integer v : list) {
            if (v < min) {
                return false;
            } else {
                min = v;
            }
        }
        return true;
    }

    private static boolean isTreeBinarySearch(TreeNode node, Integer min, Integer max) {

        if (node == null) {
            return true;
        }

        if (min != null && min < node.val) {
            return false;
        }

        if (max != null && max > node.val) {
            return false;
        }

        return isTreeBinarySearch(node.left, node.val, max) && isTreeBinarySearch(node.right, min, node.val);

    }


    private static List<Integer> getList(TreeNode node) {

        if (node == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>(getList(node.left));

        list.add(node.val);

        list.addAll(getList(node.right));

        return list;

    }


}
