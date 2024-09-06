/**
 * LeetCode - 10 - https://leetcode.com/problems/container-with-most-water/description/
 *
 * Approach:
 * 1. Area = length * width
 * 2. We need to find two largest wall with great distance that can hold more water
 * 3. Two pointers left = 0 & right = array's length-1
 * 4. maxArea = 0 in the beginning
 * 5. while (left < right):
 *      a. check the min heights between heights[left] & heights[right]
 *      b. area = minHeight * (right - left) // total water that we can store between these two walls
 *      c. if area > maxArea => maxArea = area
 *      d. if height[left] > height[right] => right--; This means I need to find higher wall on right side
 *      e. else: left++ // that means we need to check for higher wall on left side.
 * 6. return maxArea;
 */

class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int maxArea = 0;
        while (l < r) {
            int area = (r-l) * Math.min(height[l], height[r]);
            if (area > maxArea) maxArea = area;
            if (height[l] > height[r]) r--;
            else l++;
        }
        return maxArea;
    }
}