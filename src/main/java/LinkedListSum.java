import structures.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LinkedListSum {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> array1 = new ArrayList<>();
        List<Integer> array2 = new ArrayList<>();

        while (l1 != null) {
            array1.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            array2.add(l2.val);
            l2 = l2.next;
        }

        int maxArraySize = Math.max(array1.size(), array2.size());
        int sizeDiff = array1.size() - array2.size();
        int resto = 0;

        ListNode node = null;
        for (int i = maxArraySize - 1; i >= 0; i--) {

            int value1 = 0;
            int value2 = 0;

            if(sizeDiff>0) {
                value1 = array1.get(i);
                value2 = i - sizeDiff >= 0 ? array2.get(i - sizeDiff) : 0;
            }
            else{
                value1 = i + sizeDiff >= 0 ? array1.get(i + sizeDiff) : 0;
                value2 = array2.get(i);
            }

            int sum = value1 + value2 + resto;

            if (sum < 10) {
                node = new ListNode(sum, node);
            } else {
                node = new ListNode(sum % 10, node);
            }

            if (sum >= 10) {
                resto = sum / 10;

            } else {
                resto = 0;
            }
        }

        if (resto > 0) {
            node = new ListNode(resto, node);
        }

        return node;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3)));
        ListNode l2 = new ListNode(1,
                new ListNode(2));
        System.out.println("123+12= 135 : " +addTwoNumbers(l1, l2).toString());


        l1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(9,
                                        new ListNode(9)))));
        l2 = new ListNode(3,
                new ListNode(9,new ListNode(9)));
        System.out.println("12399+399= 12798 : "+addTwoNumbers(l1, l2).toString());


        l1 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9)))));
        l2 = new ListNode(9,
                new ListNode(0, new ListNode(9)));
        System.out.println("99999+909= 100908 : " +addTwoNumbers(l1, l2).toString());


        l1 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9)))));
        l2 = new ListNode(0);
        System.out.println("99999+0= 99999 : " +addTwoNumbers(l1, l2).toString());

        l1 = new ListNode(9);
        l2 = new ListNode(9,
                new ListNode(0,
                        new ListNode(9)));
        System.out.println("9+909= 918 : " +addTwoNumbers(l1, l2).toString());

        l1 = new ListNode(1,
                new ListNode(0,
                        new ListNode(9)));
        l2 = new ListNode(9);
        System.out.println("109+9= 118 : " +addTwoNumbers(l1, l2).toString());


        l1 = new ListNode(6);
        l2 = new ListNode(6);
        System.out.println("6+6= 12 : " +addTwoNumbers(l1, l2).toString());

        l1 = new ListNode(6);
        l2 = new ListNode(0);
        System.out.println("6+0= 6 : " +addTwoNumbers(l1, l2).toString());

    }


}
