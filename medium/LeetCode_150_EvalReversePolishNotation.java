/**
 * LeetCode - 150 - https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Simple stack approach. If an operator is found, then pop two numbers from stack and perform operation and push the
 * result back in the stack.
 */

class Solution {

    private int sum(Stack<Integer> nums) {
        int second = nums.pop(), first = nums.pop();
        return first + second;
    }

    private int subtract(Stack<Integer> nums) {
        int second = nums.pop(), first = nums.pop();
        return first - second;
    }

    private int multiply(Stack<Integer> nums) {
        int second = nums.pop(), first = nums.pop();
        return first * second;
    }

    private int division(Stack<Integer> nums) {
        int second = nums.pop(), first = nums.pop();
        return (int)(first/second);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) numbers.push(sum(numbers));
            else if (tokens[i].equals("-")) numbers.push(subtract(numbers));
            else if (tokens[i].equals("*")) numbers.push(multiply(numbers));
            else if (tokens[i].equals("/")) numbers.push(division(numbers));
            else numbers.push(Integer.parseInt(tokens[i]));
        }
        return numbers.pop();
    }
}