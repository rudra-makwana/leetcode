/**
 * LeetCode - 1004 - https://leetcode.com/problems/max-consecutive-ones-iii/description/
 *
 * Intuition: Sliding window technique
 *
 * We can keep track of number of zeros encounterred in our binary array.
 */

class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxW = 0; // max width encounterred till now
        int l = 0, r = 0; // left & right pointers for window
        int zeros = 0; // number of zeros in the window
        while(r < nums.length) {
            if (nums[r] == 0) {
                zeros++; // if we found a new zero at current index increase it
            }
            while(zeros > k && l <= r) { // invalid window meaning we have an extra
                if (nums[l] == 0) zeros--; // if we found the zero on left we can ignore the elements befoer it from the window
                l++; // increment the left pointer
            }
            maxW = Math.max(maxW, r - l + 1); // update maxWidth if it needs to be
            r++; // right pointer increment
        }
        return maxW;
    }
}