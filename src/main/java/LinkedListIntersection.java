import structures.ListNode;

public class LinkedListIntersection {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int sizeA = 0;
        int sizeB = 0;

        if (headA == null || headB == null) {
            return null;
        }

        ListNode lastNodeA = headA;
        while (lastNodeA.next != null) {
            lastNodeA = lastNodeA.next;
            sizeA++;
        }

        ListNode lastNodeB = headB;
        while (lastNodeB.next != null) {
            lastNodeB = lastNodeB.next;
            sizeB++;
        }

        if (lastNodeA != lastNodeB) {
            return null;
        }

        if (sizeA > sizeB) {
            for (int i = 0; i < sizeA - sizeB; i++) {
                headA = headA.next;
            }
        }
        if (sizeA < sizeB) {
            for (int i = 0; i < sizeB - sizeA; i++) {
                headB = headB.next;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;

    }


    public static void main(String[] args) {

        ListNode intersection = new ListNode(4, new ListNode(3));

        ListNode a = new ListNode(2, new ListNode(1, intersection));
        ListNode b = new ListNode(6, new ListNode(7, intersection));

        System.out.println(getIntersectionNode(a, b).toString());

    }


}
