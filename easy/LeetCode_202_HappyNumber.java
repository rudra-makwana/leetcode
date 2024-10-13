/**
 * LeetCode - 202 - https://leetcode.com/problems/happy-number/
 *
 *
 * class Solution:
 *     def isHappy(self, n: int) -> bool:
 *
 *         def get_next (n):
 *             sum = 0
 *             while (n != 0):
 *                 x = (n % 10)
 *                 sum += (x * x)
 *                 n = floor(n/10)
 *             return sum
 *
 *         visited = set()
 *         while (n != 1 and n not in visited):
 *             visited.add(n)
 *             n = get_next(n)
 *
 *         return n==1
 *
 */

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n != 1 && visited.add(n)) {
            int sum = 0;
            while (n != 0) {
                int x = n%10;
                sum += (x*x);
                n = n/10;
            }
            n = sum;
        }

        return n == 1;
    }
}