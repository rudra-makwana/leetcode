/**
 * LeetCode - 416 - https://leetcode.com/problems/partition-equal-subset-sum/description/
 *
 */

class Solution {
    private Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        if(nums.length == 1) return false;
        int sum = 0;
        // Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum%2 == 1) return false;
        sum = sum/2;
        memo = new Boolean[nums.length+1][sum+1];
        return canPartition(nums, sum, 0);
    }

    private boolean canPartition(int[] nums, int sum, int curr) {
        if (sum == 0) return true;
        if (sum < 0 || curr == nums.length){
            return false;
        }
        if (memo[curr][sum] != null) return memo[curr][sum];
        boolean res = canPartition(nums, sum-nums[curr], curr+1) || canPartition(nums, sum, curr+1);
        return memo[curr][sum] = res;
    }
}