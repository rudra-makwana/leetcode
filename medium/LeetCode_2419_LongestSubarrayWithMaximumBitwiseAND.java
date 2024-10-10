/**
 *
 * LeetCode - 2419 - https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/
 *
 * Intuition:
 * x&x will be always greater than x&y. So basically we have to calculate length of maximum elements in countinous form.
 *
 */


class Solution {
    public int longestSubarray(int[] nums) {
        if (nums.length == 0) return 0;

        int maxCount = 1, count = 1;
        int prevMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < prevMax) {
                count = 0;
                continue;
            }
            else if (nums[i] == prevMax) {
                count++;
                if (count > maxCount) maxCount = count;
            }
            else {
                prevMax = nums[i];
                count = 1;
                maxCount = 1;
            }
        }
        return maxCount;
    }
}