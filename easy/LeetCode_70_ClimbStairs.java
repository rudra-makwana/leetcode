/**
 * LeetCode - 70 - https://leetcode.com/problems/climbing-stairs/description/
 */

// Simple fibonacci logic. TC = O(n) && SC = O(1)
class Solution {
    public int climbStairs(int n) {
        if (n < 3) return n;
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int temp = second + first;
            first = second;
            second = temp;
        }
        return second;
    }
}


// Recursice Method TC = O(n) && SC = O(n)
//class Solution {
//    int[] temp;
//    private int getPossibleWays(int n) {
//        if (n <= 3){
//            return n;
//        }
//        temp[n - 1] = getPossibleWays(n - 1);
//        if (temp[n-2] == 0) temp[n-2] = getPossibleWays(n-2);
//        temp[n] = temp[n - 1] + temp[n - 2];
//        return temp[n];
//    }
//    public int climbStairs(int n) {
//        temp = new int[n + 1];
//        return getPossibleWays(n);
//    }
//}