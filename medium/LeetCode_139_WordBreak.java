/**
 * LeetCode - 139 - Word Break - https://leetcode.com/problems/word-break/description/
 *
 * This is a dynamic programming problem commonly asked in the coding interviews.
 *
 * Problem statement:
 * We will be given two inputs as follows:
 * 1. String
 * 2. List of string
 *
 * We need to check is there a possible way of building a string using the strings in the list. We can use same
 * strings multiple times as well. The goal is to see if the main string is made using any words from the list.
 *
 * Bottom Up approch:
 * We create an boolean array that shows at which points we can form a word break condition true.
 * The base case "" (an empty string) is true
 *
 * If we found a substring that matches the word in a dict that means we need to check if the part of the string must
 * be in word break form.
 *
 * So the condition would be like this:
 * isWordInDict(string.substring(start, end)) && isWordBreak(string.substring(0, start))
 *  -> both true then word break till end index is possible
 *
 * Now for second condition isWordBreak(string.substring(0, start)), we can apply memoization
 *
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict);
        boolean[] merged = new boolean[s.length() + 1]; // merged array will represent that s.substring(0, i+1) is a word break
        merged[0] = true; // empty string is always a word break

        for(int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (
                        merged[start] // it checks the substring(0, start) must be in word break form
                                && dict.contains(s.substring(start, end))
                    // substring from start to end is also a dict word means substring till end can be word break string
                ) {
                    merged[end] = true;
                    break;
                }
            }
        }
        return merged[s.length()];
    }
}


/**
 * We can approach follow Top Down Approach to solve this problem.
 * 1: We try to see if we can split the main input string at each index and check following two things:
 *      a. if left part of the break is in the list
 *      b. apply recursice function on the right part of the break to see if we can do it till the end.
 * --------------------------------------------------------------------------------------------------
 * Intuition:
 * --------------------------------------------------------------------------------------------------
 *    Ex:
 *    S = "leetcode" and dict = {"leet", "code"}; break point b = 0 initially
 *    Boolean[] visited = An array containing boolean object similar of size of the main string
 *
 *    Pass1:
 *    b = 0 -> left = "" and right = "leetcode"
 *    left == true as we can create empty string without using any words from the dict
 *
 *    that means we applpy the recursice call on right part. start = 0;
 *    b = start
 *    b = 1 -> left = "l" right = "eetcode" left failed the first condition
 *    b = 2 -> left = "le" right = "etcode" left failed
 *    b = 3 -> left = "lee" right = "tcode" left failed
 *    b = 4 -> left = "leet" right = "code" left passed apply recursion on right and set start = 4
 *
 *    b = 5 -> left = "c" right = "ode" left failed
 *    b = 6 -> left = "co" right = "de" left failed
 *    b = 7 -> left = "cod" right = "e" left failed
 *    b = 8 -> left = "code" right = "" left passed apply recursion on right and set start = 8
 *
 *    start == size of the actual string retutrn true
 *
 *    b == 8 rec call left = true && right = true => return true
 *
 *    b == 4 rec call left = true && right = true => return true
 *
 *    b == 0 rec call (main call from the actual function) -> return true
 *
 * --------------------------------------------------------------------------------------------------
 * Code:
 * --------------------------------------------------------------------------------------------------
 * class Solution {
 *     public boolean wordBreak(String s, List<String> wordDict) {
 *         return wordBreak(s, new HashSet<String>(wordDict), 0, new Boolean[s.length()]);
 *     }
 *
 *     private boolean wordBreak(String s, Set<String> dict, int start, Boolean[] visited) {
 *         if (start == s.length()) return true;
 *         if(visited[start] != null) return visited[start];
 *         for (int end = start + 1 ; end <= s.length(); end++) {
 *             if (dict.contains(s.substring(start, end))
 *                 && wordBreak(s, dict, end, visited)) {
 *                     return visited[start] = true;
 *                 }
 *         }
 *         return visited[start] = false;
 *     }
 * }
 */