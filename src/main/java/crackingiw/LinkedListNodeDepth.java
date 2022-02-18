package crackingiw;

import structures.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static crackingiw.MinimalTree.treeBinarizeOrderedArray;

public class LinkedListNodeDepth {

    //4.3 starting from a binary tree, design an algorithm which creates a linked list with all the nodes at each depth
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode node = treeBinarizeOrderedArray(array);
        System.out.println(node.toString());

        Map<Integer, LinkedList<TreeNode>> listMap = new HashMap<>();

        populateMap(node, listMap, 0);

        System.out.println(listMap.size());

    }

    private static void populateMap(TreeNode node, Map<Integer, LinkedList<TreeNode>> listMap, int level) {

        if (node == null) {
            return;
        }

        if (listMap.containsKey(level)) {
            LinkedList<TreeNode> listNode = listMap.get(level);
            listNode.add(node);
        } else {
            LinkedList<TreeNode> listNode = new LinkedList<>();
            listNode.add(node);
            listMap.put(level, listNode);
        }

        ++level;
        populateMap(node.left, listMap, level);
        populateMap(node.right, listMap, level);
    }

}
