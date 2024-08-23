/**
 * LeetCode - 52 - https://leetcode.com/problems/maximum-subarray/
 */

/**
 * Approach 1 - sliding window technique: TC = O(n) & SC = O(1)
 *
 * First condition is till my max sum is non-positive value and current selected element is larger than the max, then
 * I reset my max to that element as it will give me always higher sum. Set my current sum to max as well. This is to
 * help us to find the start of the sliding windows. This condition will give us a max sum of subarray of size 1.
 *
 * If my max sum is greater than 0 and my current sum is greater than 0 then check followins:
 * a. If sum > max then replace my max with sum and continue the loop
 * b. If sum <= 0 then reset the sum to 0. This is because if we are here meaning our max is always greater than 0. And
 * now we need to find another subarray that can give us new subarray with max sum.
 * c. If sum > 0 but sum < max then continue without doing anything.
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = max;
        for (int i = 0; i < nums.length; i++) {
            if (max <= 0) {
                if (nums[i] > max) {
                    max = nums[i];
                    sum = max;
                }
            } else {
                sum = sum + nums[i];
                if (sum < 0) sum = 0;
                if (max < sum) max = sum;
            }
        }
        return max;
    }
}