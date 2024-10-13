/**
 *
 * LeetCode - 268 - https://leetcode.com/problems/missing-number/
 *
 */

class Solution {
    public int missingNumber(int[] nums) {
        int expected = nums.length;
        for (int i = 0; i < nums.length; i++) {
            expected += i;
            expected -= nums[i];
        }

        return expected;
    }
}