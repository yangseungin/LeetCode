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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummy = head;
        while (dummy != null) {
            int i = 0;
            ListNode tmp = dummy;
            Stack<Integer> stack = new Stack<>();

            for (; i < k && tmp != null; i++) {
                stack.push(tmp.val);
                tmp = tmp.next;
            }

            while (i == k && !stack.isEmpty()) {
                dummy.val = stack.pop();
                dummy = dummy.next;
            }
            if (i != k) {
                break;
            }
        }

        return head;
    }
}