/**
 * LeetCode - 704 - https://leetcode.com/problems/binary-search/description/
 */

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = (right + left) / 2;
        while (mid <= right && mid >= left) {
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (right + left)/2;
        }
        return -1;
    }
}