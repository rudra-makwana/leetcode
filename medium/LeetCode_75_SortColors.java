/**
 * LeetCode - 75 - https://leetcode.com/problems/sort-colors/
 *
 * Initial approch - sorting the nums O(n*log(n))
 * 2nd Approch - take counts of 0, 1 & 2 and add them one by one in the nums (two array) => O(2*n)
 *
 * 3rd Approch - Dutch National Flag algorithm -> O(n)
 * Logic:
 * -> if we find 0 on current pointer, shift it to the left pointer. Increase left pointer and current pointer.
 * -> if we find 2 then shift it to the right pointer the decrement the right pointer only
 *
 */

class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        int c = 0;
        while (c <= r) {
            if (nums[c] == 0) {
                int temp = nums[l];
                nums[l] = nums[c];
                nums[c] = temp;
                l++;
                c++; // <----------
            } else if (nums[c] == 2) {
                int temp = nums[r];
                nums[r] = nums[c];
                nums[c] = temp;
                r--;
            } else c++;
        }
    }
}