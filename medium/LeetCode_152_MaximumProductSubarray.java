/**
 * LeetCode - 152 - https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * My first approach was to maintain a two dimensional array which stores previous index elements max and min product.
 * But we can simply replace 2D array with 2 variables which holds previous elements max and min products which saves
 * some time.
 */

class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
//        int[][] dp = new int[nums.length][2]; no need of this
//        dp[0] = new int[]{nums[0], nums[0]};
        int prevMax = nums[0], prevMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int c = nums[i];
            int t1 = Math.max(c, Math.max(prevMax * c, prevMin * c));
            prevMin = Math.min(c, Math.min(prevMin * c, prevMax * c));
            prevMax = t1;
            max = Math.max(prevMax, max);
        }
        return max;
    }
}