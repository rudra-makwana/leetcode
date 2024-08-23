/**
 * LeetCode - 169 - https://leetcode.com/problems/majority-element/description/
 */

// Boyer-Moore approach:
// +1 for majority candidate and -1 for negative candidate.
// count(majorityElement) >= [n/2] means count > 0 for the specific elements always.
// For example: 100 nums. 51 of them are 1 and 49s are 0s. [0:48] == 0 && [49:99] == 1
// That means even if we start from zeros, we will have a reset of count at index 98 that means we reset
// our majority to the new element. That means at the end it will be positive for our current majority at the end
// TC = O(n) && SC = O(1)

class Solution {
    public int majorityElement(int[] nums) {
        int maj = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) maj = nums[i];
            if (nums[i] == maj) count++;
            else count--;
        }
        return maj;
    }
}


// TC = O(n) && SC = O(n)
//class Solution {
//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> t = new HashMap<>();
//        int maxC = -1, maxV = 0;
//        for (int i = 0; i < nums.length; i++ ) {
//            int c = t.getOrDefault(nums[i], 0) + 1;
//            t.put(nums[i], c);
//            if (c > maxC) {
//                maxC = c;
//                maxV = nums[i];
//            }
//        }
//        return maxV;
//    }
//}