/**
 *
 * LeetCode - 35 - https://leetcode.com/problems/search-insert-position/description
 *
 * Binary Search Algorithm
 *
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) r = mid;
            else l = mid + 1;
        }
        if (l == nums.length - 1 && target > nums[l]) return l+1;
        return l;
    }
}


