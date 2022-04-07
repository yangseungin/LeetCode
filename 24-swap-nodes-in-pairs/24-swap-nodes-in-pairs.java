/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;

        ListNode n1 = head;
        ListNode n2 = head.next;

//    A - B -  C - D
        while (n1 != null && n2 != null) {
            res.next = n2;
            ListNode tmp = n2.next;
            n2.next = n1;
            res = n1;

            n1.next = tmp;
            n1 = n1.next;

            if (tmp != null) {
                n2 = tmp.next;
            }


        }

        return dummy.next;
    }
}