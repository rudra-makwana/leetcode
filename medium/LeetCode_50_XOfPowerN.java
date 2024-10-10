/**
 * LeetCode - 50 - https://leetcode.com/problems/powx-n/
 *
 * My first approach: Use iteration and multiply x to x by n times.
 * Or it can be written in recursive function that will do the same.
 *
 * x^n = x^(n/2) * x^(n/2) if n is even
 * x^n = x^(n/2) * x^(n/2) * x if n is odd
 * meaning we can reuse n/2's solution again to get n.
 *
 * Why 2 and not 3 or other numbers?
 * The reason is simple. Increasing the division meaning increasing the number of remainder and that means more number
 * of conditions. For example:
 *
 * x^n = x^(n/3) * x^(n/3) * x^(n/3) if (x%3 == 0)
 * x^n = x^(n/3) * x^(n/3) * x^(n/3) * x if (x%3 == 1)
 * x^n = x^(n/3) * x^(n/3) * x^(n/3) * x * x if (x%3 == 2)
 *
 * So higher the divisior meaning more the remainder cases.
 * The code is written with the use of divisor 3 in the comment at the end of the file.
 */

class Solution {
    private double pow(double x, int n) {
        if (x == 0 || x == 1 || n == 1) return x;
        if (n == 0) return 1;
        double temp = pow(x, n/2);
        return (n%2 == 0) ? temp * temp : x * temp * temp;
    }

    public double myPow(double x, int n) {
        if (n < 0) return pow((double)1/x, -1*n);
        return pow(x, n);
    }
}

/**
 * class Solution {
 *     private double pow(double x, int n) { // it will be faster than the above code
 *         if (x == 0 || x == 1 || n == 1) return x;
 *         if (n == 0) return 1;
 *         double temp = pow(x, n/3);
 *         temp = temp * temp * temp;
 *         if (n%3 == 0) return temp; // condition 1
 *         if (n%3 == 1) return x * temp; // condition 2
 *         return x * x * temp; // condition 3
 *     }
 *
 *     public double myPow(double x, int n) {
 *         if (n < 0) return pow((double)1/x, -1*n);
 *         return pow(x, n);
 *     }
 * }
 */