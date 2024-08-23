/**
 * LeetCode - 238 - https://leetcode.com/problems/product-of-array-except-self/
 *
 * My inital approach:
 * Logic:
 * First I will start multiplying the profucts from left to right.
 * Second loop will multiply it from right to left.
 * Both loop must not include the self.
 *
 * Pseudo code:
 * 1. empty array of same size as nums.
 * 2. A variable that stores a previously calculated product. Initially it will be set to 1.
 * 3. Set ans[0] = 1
 * 4. for loop from i == 1 to n-1:
 *      a. prevProd = prevProd * nums[i-1]
 *      b. ans[i] = prevProd
 * 5. for loop from i == n-2 to 0:
 *      a. prevProd = prevProd * nums[i+1]
 *      b. ans[i] = ans[i] * prevProd
 * 6. return ans
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length];
        int prevProd = 1;
        ans[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            prevProd = prevProd * nums[i - 1];
            ans[i] = prevProd;
        }
        prevProd = 1;
        for(int i = nums.length - 2; i >=0; i--) {
            prevProd = prevProd * nums[i+1];
            ans[i] = ans[i] * prevProd;
        }
        return ans;
    }
}