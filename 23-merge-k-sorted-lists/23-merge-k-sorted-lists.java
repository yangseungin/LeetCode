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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> que = new PriorityQueue(Comparator.comparingInt((ListNode l) -> l.val));

        ListNode head = new ListNode(0), headNext = head;
        for (ListNode node : lists) {
            if (node != null) {
                que.offer(node);
            }
        }
        while (!que.isEmpty()) {
            headNext.next = que.poll();
            headNext = headNext.next;
            if (headNext.next != null)
                que.offer(headNext.next);
        }


        return head.next;
    }
}