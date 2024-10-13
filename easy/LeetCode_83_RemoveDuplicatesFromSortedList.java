/**
 * LeetCode - 83 - https://leetcode.com/problems/remove-duplicates-from-sorted-list/description
 *
 * Python:
 * # Definition for singly-linked list.
 * # class ListNode:
 * #     def __init__(self, val=0, next=None):
 * #         self.val = val
 * #         self.next = next
 * class Solution:
 *     def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
 *         if not head: return head
 *
 *         prev = head
 *         curr = head.next
 *
 *         while curr:
 *             while (curr and (prev.val == curr.val)):
 *                 prev.next = curr.next
 *                 curr = curr.next
 *             prev = curr
 *             if not curr: break
 *             curr = curr.next
 *
 *         return head
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null) {
            while (curr != null && prev.val == curr.val) {
                prev.next = curr.next;
                curr = curr.next;
            }
            prev = curr;
            if (curr == null) break;
            curr = curr.next;
        }
        return head;
    }
}