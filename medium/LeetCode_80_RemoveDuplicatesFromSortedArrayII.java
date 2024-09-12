/**
 *
 * LeetCode - 80 - https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 *
 * First approach was brute force.
 *
 * Better approach mentioned below (Used a solution from other developer as a guidance)
 * Idea we can use two pointers approch.
 * i to go through each element of the element. j will point on the next valid location to be rewritten
 *
 * If we find the duplicates more than 2 then i will increase but j will stay as it is.
 *
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) { // iterating over the elements
            if (j == 1 || nums[i] != nums[j - 2]) { // if first time or j-2 is not same as j that means count < 2
                nums[j++] = nums[i]; // ith value on jth position. J won't increment till we find no match on ith and ith-2 meaning j will point on next element of the invalid duplicates
            }
        }
        return j;
    }
}