import structures.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {

    /**
     * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
     * <p>
     * Initially, all next pointers are set to NULL.
     * <p>
     * <p>
     * Input: root = [1,2,3,4,5,null,7]
     * Output: [1,#,2,3,#,4,5,7,#]
     * <p>
     * Explanation: Given the above binary tree (Figure A),
     * your function should populate each next pointer to point to its next right node,
     * The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
     */
    public Node connect(Node root) {
        traverse(root, 0, new ArrayList<Node>());
        return root;
    }

    private void traverse(Node node, int depth, ArrayList<Node> mostLeftNodeListAtDepth) {

        if (node == null) {
            return;
        }

        if (depth >= mostLeftNodeListAtDepth.size()) {
            mostLeftNodeListAtDepth.add(node);
        } else {
            mostLeftNodeListAtDepth.get(depth).next = node;
            mostLeftNodeListAtDepth.set(depth, node);
        }

        traverse(node.left, depth + 1, mostLeftNodeListAtDepth);
        traverse(node.right, depth + 1, mostLeftNodeListAtDepth);

    }

    public Node anotherOne(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        if (root != null) {
            q.offer(root);
        }

        /**
         * TODO
         */
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (i < size - 1) {
                    node.next = q.peek();
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return root;
    }


}
