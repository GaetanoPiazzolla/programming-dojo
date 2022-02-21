import structures.ListNode;

import java.util.Random;

public class LinkedListRandomNode {

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);

        Solution obj = new Solution(head);
        System.out.println(obj.getRandom());

    }

    static class Solution {

        int size = 0;
        ListNode head;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head = head;
            ListNode next = head.next;
            size++;
            while (next != null) {
                next = next.next;
                size++;
            }

        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            Random random = new Random();
            ListNode next = head;

            int number = random.nextInt(size);

            for (int i = 0; i < number; i++) {
                next = next.next;
            }
            return next.val;
        }

    }


}

