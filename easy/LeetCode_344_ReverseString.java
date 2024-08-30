/**
 * LeetCode - 344 - https://leetcode.com/problems/reverse-string/description/
 */
class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length-1;
        while(l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}