/**
 * LeetCode - 338 - https://leetcode.com/problems/counting-bits/description/
 *
 * Bit manipulation with dynamic programming
 *
 * Number of 1s in the
 *
 */

class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++) {
            res[i] = res[i/2] + (i%2); // >> right shift -> divides numbers/2 to it's int val && i&2 same as i%2
        }
        return res;
    }
}