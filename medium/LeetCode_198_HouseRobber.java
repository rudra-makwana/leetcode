/**
 * LeetCode - 198 - https://leetcode.com/problems/house-robber/description/
 *
 * My approach:
 * Dynamic Programming - Top to Bottom method with memoization
 *
 * Idea behind my initial thought was to identify what what maximum amount can I make at this house.
 * We can create an array that will store maximum we can get till that house.
 *
 * 1st(index 0) and 2nd(index 1) house will have the maximum as their current prices.
 * At 3rd house, my maximum will be nums[2] + nums[0]
 *
 * Now starting from the 4th index, I know that the maximum I can make is like this
 *  max[i] = Math.max(nums[i]+max[i-2],nums[i]+max[i-3]) // kind of a climbing stairs. But we need to find maximum here.
 */

class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        if (size < 2) return nums[0];
        int[] max = new int[size];
        max[0] = nums[0];
        max[1] = nums[1];
        for (int i = 2; i < size; i++) {
            if (i < 3) max[i] = nums[i]+max[i-2];
            else max[i] = Math.max(nums[i]+max[i-2], nums[i]+max[i-3]);
        }
        return max[size-1] > max[size-2] ? max[size-1] : max[size-2];
    }
}