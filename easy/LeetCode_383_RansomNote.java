/**
 * LeetCode - 383 - https://leetcode.com/problems/ransom-note/description/
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] charCount = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            charCount[magazine.charAt(i) - 97]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (charCount[ransomNote.charAt(i) - 97] == 0) return false;
            charCount[ransomNote.charAt(i) - 97]--;
        }
        return true;
    }
}