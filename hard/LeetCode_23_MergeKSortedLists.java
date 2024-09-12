/**
 * LeetCode - 23 - https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * We can solve it same as merging two sorted lists approach.
 *
 * Another approach we can try is by using PriorityQueue with modified compareTo function. This will sort our nodes
 * in sorted manner as they are addeing the queue.
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
    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(-1);
        ListNode top = temp;
        while(list1 != null || list2 != null) {
            if (list1 == null) {
                temp.next = list2;
                break;
            }
            if (list2 == null) {
                temp.next = list1;
                break;
            }
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        return top.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode merged = lists[0];
        for(int i = 1; i < lists.length; i++) {
            merged = mergeTwoList(merged, lists[i]);
        }
        return merged;
    }

}