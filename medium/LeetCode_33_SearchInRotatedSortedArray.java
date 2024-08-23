/**
 * LeetCode - 33 - https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Approach 1: Single binary search loop
 *
 * 1. t == mid return mid's index
 * 2. if mid >= l:
 *      a. if t <= mid && t >= l ----> r = mid - 1
 *      b. else l = mid + 1
 * 3. else:
 *      a. if t >= mid && t <= r ----> l = mid + 1
 *      b. else r = mid - 1
 * 4. return -1 if no match found
 */

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if(target == nums[mid]) return mid;
            if (nums[mid] >= nums[l]) {
                if (target <= nums[mid] && target >= nums[l]) r = mid - 1;
                else l = mid + 1;
            } else {
                if (target <= nums[r] && target >= nums[mid]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}