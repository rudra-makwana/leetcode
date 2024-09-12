/**
 *
 * LeetCode - 6 - https://leetcode.com/problems/zigzag-conversion/description/
 *
 * Before getting into solution afeter reading the problem statements, let's take a look at the example input and output
 *
 * Ex: String = "PAYPALISHIRING" and rows = 4
 *
 * Matrix will look like this
 * P     I     N
 * A   L S   I G
 * Y A   H R
 * p     I
 *
 * answer would be PINALSIGYAHRPI
 *
 * Now looking at the matrix,
 * first row    P - jump of 6 -> I - Jump of 6 -> N
 * second row   A - jump of 4 -> L - Jump of 2? -> S - Jump of 4 -> I - Jump of 2? -> G
 *
 * First row we had only one jump but in second row we had two jumps (left & right).
 * Actually each row needs two jumps except first and last rows.
 * at each row we decrement left jump and increment right jump by 2 to get the ZigZag pattern.
 *
 * Look at the code for better understanding.
 */


class Solution {
    public String convert(String s, int numRows) {
        int size = s.length();
        if (size < 2 || numRows == 1) return s;
        int leftJump = 2 * (numRows - 1);
        int rightJump = 0;
        int elem = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int curr = elem;
            while (curr < size) {
                if (leftJump > 0) {
                    res.append(s.charAt(curr));
                    curr += leftJump;
                }
                if (rightJump > 0 && curr < size) {
                    res.append(s.charAt(curr));
                    curr += rightJump;
                }
            }
            leftJump -= 2;
            rightJump += 2;
            elem++;
        }
        return res.toString();
    }
}