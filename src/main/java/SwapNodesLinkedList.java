import structures.ListNode;

public class SwapNodesLinkedList {

    /**
     * You are given the head of a linked list, and an integer k.
     * Return the head of the linked list after swapping the values
     * of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
     * Example:
     * 1 - 2 - 3 - 4 - 5 with k = 2 becomes 1 - 4 - 3 - 2 - 5
     */
    public ListNode swapNodes(ListNode head, int k) {

        // I will swap K and N-K
        ListNode first = head;
        ListNode second = head;
        ListNode pointer = head;

        int count = 1;
        while(count++ < k){
            pointer=pointer.next;
        }

        first = pointer;

        // Second will be at N-K position
        while(pointer.next!=null) {
            second = second.next;
            pointer = pointer.next;
        }

        int temp = second.val;
        second.val = first.val;
        first.val = temp;

        return head;
    }


}
