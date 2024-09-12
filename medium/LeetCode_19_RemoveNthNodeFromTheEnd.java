/**
 * LeetCode - 19 - https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * - Such node exisits in the list.
 *
 * Two pointer method that with a gap size of n.
 * 1. Store the head to curr and future
 * 2. Iterate n time to create a gap of size n between future node and curr node.
 * 3. Now Continue traversing to next of both untill future becomes null. Also maintain a prev node pointing the head
 * to keep the track of immediate previous element. Remove the curr node's connection from prev node.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode forward = head;
        for(int i = 0; i < n; i++) {
            forward = forward.next;
        }
        ListNode prev = null;
        while (forward != null) {
            prev = curr;
            curr = curr.next;
            forward = forward.next;
        }
        if (prev == null) {
            if (n == 1) return null;
            else return head.next;
        }
        prev.next = curr.next;
        return head;
    }
}