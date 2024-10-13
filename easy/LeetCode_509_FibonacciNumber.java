/**
 * LeetCode - 509 - https://leetcode.com/problems/fibonacci-number/description
 *
 * Python:
 * class Solution:
 *     def fib(self, n: int) -> int:
 *         if (n < 2): return n
 *         p1 = 1
 *         p2 = 0
 *         for i in range(2, n+1):
 *             temp = p2
 *             p2 = p1
 *             p1 = p2 + temp
 *
 *         return p1
 *
 */

class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        int p1 = 0, p2 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = p1;
            p1 = p2;
            p2 = p1 + temp;
        }
        return p2;
    }
}