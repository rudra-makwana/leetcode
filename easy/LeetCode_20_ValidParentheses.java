/**
 * LeetCode - 20 - https://leetcode.com/problems/valid-parentheses/description/
 */

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(pairs.containsKey(curr)) stack.push(curr);
            else {
                if (stack.empty()) return false;
                else if (curr != pairs.get(stack.peek())) return false;
                else stack.pop();
            }
        }
        if (!stack.empty()) return false;
        return true;
    }
}