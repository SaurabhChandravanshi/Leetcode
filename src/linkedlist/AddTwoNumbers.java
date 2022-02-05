package linkedlist;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode result = new ListNode();
        ListNode sum = result;

        while (temp1 != null && temp2 != null) {
            ListNode listNode = new ListNode();
            int addition = temp1.val + temp1.val + carry;
            carry = addition/10;
            listNode.val = addition;
            if(sum == null) {
                sum = listNode;
            } else {
                sum.next = listNode;
                sum = sum.next;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return result;
    }
}
