import structures.ListNode;

public class MergeArrayList {

        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            if(l1 == null){
                return l2;
            }

            if(l2 == null){
                return l1;
            }


            ListNode node = new ListNode();
            ListNode solution = node;

            while(l1 != null && l2 != null)
            {
                if(l1.val > l2.val)
                {
                    node.next = new ListNode(l2.val);
                    l2 = l2.next;
                }

                else
                {
                    node.next = new ListNode(l1.val);
                    l1 = l1.next;
                }

                node = node.next;
            }

            while(l1 != null){
                node.next = new ListNode(l1.val);
                l1 = l1.next;
                node= node.next;
            }

            while(l2 != null){
                node.next = new ListNode(l2.val);
                l2 = l2.next;
                node = node.next;
            }

            return solution.next;
        }


        public static void main (String[] args) {

            ListNode l1 = new ListNode(-9);
            l1.next = new ListNode(3);

            ListNode l2 = new ListNode(5);
            l2.next = new ListNode(7);

            System.out.println(mergeTwoLists(l1,l2));

        }



}
