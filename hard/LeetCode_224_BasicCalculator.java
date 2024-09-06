/**
 * LeetCode - 224 - https://leetcode.com/problems/basic-calculator/description/
 *
 * Explanation:
 */

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        int result = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                operand = 10 * operand + (int) c - '0';
            } else if (c == '+') {
                result += sign * operand;
                sign = 1;
                operand = 0;
            } else if (c == '-') {
                result += sign * operand;
                operand = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);

                sign = 1;
                operand = 0;
                result = 0;
            } else if (c == ')') {
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
            }
        }
        return result + operand*sign;
    }
}