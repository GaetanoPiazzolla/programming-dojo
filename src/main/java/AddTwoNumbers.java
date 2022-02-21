import structures.ListNode;

public class AddTwoNumbers {


    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = new ListNode();

        recursiveAdding(l1, l2, node, 0);

        return node.next == null ? new ListNode(0) : node.next;
    }

    private static void recursiveAdding(ListNode l1, ListNode l2, ListNode node, int carry) {

        int first = 0;
        int second = 0;

        if (l1 != null) {
            first = l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            second = l2.val;
            l2 = l2.next;
        }

        int sum = first + second + carry;

        if (sum == 0 && l1 == null && l2 == null) {
            return;
        }

        node.next = new ListNode();
        if (sum >= 10) {
            node.next.val = sum % 10;
            carry = sum / 10;
        } else {
            node.next.val = sum;
            carry = 0;
        }

        recursiveAdding(l1, l2, node.next, carry);
    }


    public static void main(String[] args) {

        ListNode first = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode second = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode sum = addTwoNumbers(first, second);
        printNode(sum); // 708

        first = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        second = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        sum = addTwoNumbers(first, second);
        printNode(sum); // 89990001

        first = new ListNode(0);
        second = new ListNode(0);
        sum = addTwoNumbers(first, second);
        printNode(sum); // 0

        first = new ListNode(9, new ListNode(9));
        second = new ListNode(0);
        sum = addTwoNumbers(first, second);
        printNode(sum); // 99

        first = new ListNode(9, new ListNode(0, new ListNode(9)));
        second = new ListNode(9, new ListNode(0, new ListNode(9)));
        sum = addTwoNumbers(first, second);
        printNode(sum); // 8181

    }

    private static void printNode(ListNode sum) {
        StringBuilder b = new StringBuilder();
        while (sum != null) {
            b.append(sum.val);
            sum = sum.next;
        }
        System.out.println(b);
    }

}
