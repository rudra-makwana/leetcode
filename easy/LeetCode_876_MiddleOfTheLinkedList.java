/**
 * LeetCode - 876 - https://leetcode.com/problems/middle-of-the-linked-list/description/
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
    public ListNode middleNode(ListNode head) {
        ListNode mid = head;
        ListNode second = head;
        while (second != null && second.next != null) {
            mid = mid.next;
            second = second.next.next;
        }
        return mid;
    }
}

/*
* What is our goal here?
* We are trying to find the middle of the element in the linked list. If the linked list is even that means we will have
* 2 mid points, then we have to return the second mid point.
*
* What have we done here to achieve the goal?
* We have used fast runner & slow runner approch. Fast runner is running twice the speed of slow runner. That means
* when fast runner riches the end, our slower runner will be at the middle point. That means we can find the middle
* point in O(n/2) approaches.
*
* Algorithm:
* 1. create a two pointers: 1. fast and 2. slow.
* 2. Both starts from the head (the beginning).
* 3. while fast hasn't reached the end or not about to reach, we continuously increase one pointer for slow and two
* pointers for fast
* 4. once while loop has stopped we return the slow's pointer.
* */