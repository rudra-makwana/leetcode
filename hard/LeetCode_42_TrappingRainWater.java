/**
 * LeetCode - 42 - https://leetcode.com/problems/trapping-rain-water/description/
 *
 * Intuition:
 * 1. Water cannot be trapped higher than the minimum of leftMax and rightMax
 * 2. We only add the water till left < right
 *      a. If left > right:
 *          i. if leftMax < left then leftMax = left
 *          ii. else area += (leftMax - left)
 *          iii. left++;
 *      b. Else:
 *          i. if rightMax < right then rightMax = right
 *          ii. else area += (rightMax - right)
 *          iii. right++
 * 3. return area
 *
 */

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int res = 0;
        int lMax = 0, rMax = 0;
        while(left < right) {
            if (height[left] < height[right]) { // we are continuing till our left is smaller than right pointer's height
                if (height[left] > lMax) lMax = height[left]; // leftMax is smaller than current height change leftMax to height[left]
                else {
                    res += lMax - height[left]; // otherwise increase the trapped water volume
                }
                left++; // left counter increment
            } else { // this means our left height is bigger than right pointer's height. we need to check reduce from right side to calculate trapped water
                if (height[right] >= rMax) rMax = height[right];
                else {
                    res += rMax - height[right];
                }
                right--;
            }
        }
        return res;
    }
}