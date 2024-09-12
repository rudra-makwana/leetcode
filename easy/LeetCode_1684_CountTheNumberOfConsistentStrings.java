/**
 * LeetCode - 1684 - https://leetcode.com/problems/count-the-number-of-consistent-strings/description
 */

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        char[] allowedC = new int[26];
        for(char c: allowed.toCharArray()) allowedC = [];
        int c = 0;
        for (String word: words) {
            boolean consistent = true;
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) c++;
        }
        return c;
    }
}