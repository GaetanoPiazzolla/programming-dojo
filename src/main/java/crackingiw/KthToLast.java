package crackingiw;

import structures.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class KthToLast {

    public static void main(String[] args) {

        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));

        int k = 3;
        Queue<Integer> queue = new ArrayDeque<>(k);
        ListNode node = list;
        while (node != null) {
            if (queue.size() > k) {
                queue.remove();
            }
            queue.add(node.val);
            node = node.next;
        }
        System.out.println(queue.poll());
    }
}
