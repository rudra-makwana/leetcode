/**
 * LeetCode - 22 - https://leetcode.com/problems/generate-parentheses/description/
 *
 * Backtracking problem as we need to develop all valid possible paranthesis
 *
 */


class Solution {
    private List<String> answer;
    private int num;

    private void generateParenthesis(
            StringBuilder currString,
            int openings, // how many opening brackets are created.
            int closings // how many brackets were closed
    ) {
        if (currString.length() == 2 * num) {
            answer.add(currString.toString());
            return;
        }

        if (openings < num) {
            currString.append('(');
            generateParenthesis(currString, openings + 1, closings);
            currString.deleteCharAt(currString.length() - 1);
        }

        if (openings > closings) {
            currString.append(')');
            generateParenthesis(currString, openings, closings + 1);
            currString.deleteCharAt(currString.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        num = n;
        answer = new ArrayList<>();
        generateParenthesis(new StringBuilder(), 0, 0);
        return answer;
    }
}