/**
 * LeetCode - 287 - https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Similar approach like finding a cycle in linked list.
 *
 */

class Solution {
    public int findDuplicate(int[] nums) {
        int slower = nums[0], faster = nums[0];
        do {
            faster = nums[nums[faster]];
            slower = nums[slower];
        } while (faster != slower);

        slower = nums[0];

        while (slower != faster) {
            slower = nums[slower];
            faster = nums[faster];
        }
        return slower;
    }
}