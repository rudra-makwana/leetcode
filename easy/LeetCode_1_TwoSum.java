/**
 * LeetCode Problem: 1 - https://leetcode.com/problems/two-sum/description/
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> difference = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (difference.containsKey(nums[i])) {
                return new int[] {difference.get(nums[i]), i};
            }
            difference.put(target-nums[i], i);
        }
        return new int[]{-1, -1};
    }
}