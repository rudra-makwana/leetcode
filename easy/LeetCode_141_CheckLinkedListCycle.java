/**
 * LeetCode - 141 - https://leetcode.com/problems/linked-list-cycle/description/
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    private boolean checkCycleWithSet(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) return true;
            visited.add(head);
            head = head.next;
        }
        return false;
    }

    private boolean checkCycleWithTwoPointers(ListNode head) {
        if (head == null) return false;
        ListNode p1 = head, p2 = head.next;
        while (p1 != p2) {
            if (p2 == null || p2.next == null) return false;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return true;
    }

    public boolean hasCycle(ListNode head) {
        return checkCycleWithTwoPointers(head);
    }
}