/**
 *
 * LeetCode - 977 - https://leetcode.com/problems/squares-of-a-sorted-array/description/
 *
 * The given array is sorted and contains the all types of integer values.
 * So the possibility of getting larger values are both ends due to negative's square can be large.
 *
 * So what can we do is, we iterate on the array from the both end using two pointers method.
 * One pointer checks left end and another pointer on righ hand side of the array.
 *
 * We can compare both values and see which one is larger, and add them to result array starting from the end.
 *
 * Time Complexity would be O(n) as we iterate over the input array only once.
 * Space Complexity would be O(n) due to creating an new array of same size as input array.
 *
 */

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0, r = nums.length-1;
        int i = r;
        while(l <= r) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                res[i] = nums[l] * nums[l];
                l++;
            } else {
                res[i] = nums[r] * nums[r];
                r--;
            }
            i--;
        }
        return res;
    }
}

/**
 TC = O(n*long(n)) && SC = O(1)
 No space but extra time

 class Solution {
 public int[] sortedSquares(int[] nums) {
 for (int i = 0; i < nums.length; i++) {
 nums[i] = nums[i] * nums[i];
 }
 Arrays.sort(nums);
 return nums;
 }
 }
 */