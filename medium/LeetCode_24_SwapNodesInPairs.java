/**
 *
 * LeetCode - 24 - https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 */


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
        if (head == null || head.next == null) return head;
        Deque<ListNode> q = new ArrayDeque();
        q.addLast(head);
        ListNode prev = new ListNode(-1);
        ListNode res = prev;
        while(!q.isEmpty()) {
            ListNode n1 = q.removeFirst();
            if (n1.next == null) break;
            ListNode n2 = n1.next;
            n1.next = n2.next;
            n2.next = n1;
            prev.next = n2;
            prev = n1;
            if (n1 != null && n1.next != null) q.addLast(n1.next);

        }
        return res.next;
    }
}