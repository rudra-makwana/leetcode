/**
 *
 * LeetCode - 21 - https://leetcode.com/problems/merge-two-sorted-lists/description/
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return (list1 == null) ? list2 : list1;
        }

        ListNode start = null;
        ListNode curr = new ListNode();
        ListNode prev = new ListNode();
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.val = list1.val;
                list1 = list1.next;
            } else {
                curr.val = list2.val;
                list2 = list2.next;
            }
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;

            if (start == null){ start = prev;}
        }
        if (list1 == null) {
            curr.val = list2.val;
            curr.next = list2.next;
        }
        if (list2 == null) {
            curr.val = list1.val;
            curr.next = list1.next;
        }
        return start;
    }
}




// Recursion method. TC = O(n+m) && SC = O(n+m) due to stacking of recursion call
// if (list1 == null || list2 == null) return list1 == null ? list2 : list1;
// if (list1.val < list2.val) {
//     list1.next = mergeTwoLists(list1.next, list2);
//     return list1;
// } else {
//     list2.next = mergeTwoLists(list2.next, list1);
//     return list2;
// }