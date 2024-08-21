/**
 * LeetCode - 67 - https://leetcode.com/problems/add-binary/description/
 */

// Sum of two binary strings. E.g.: a = "1010" & b = "101" then (a+b) = "1111"
// Using string builder. TC = O(n) n >= m (n & m string's size) SC = O(n)
// Another approach is to use inbuilt function but this is better function.

class Solution {
    public String addBinary(String a, String b) {
        boolean c = false;
        int l1 = a.length() - 1, l2 = b.length() - 1;
        StringBuilder res = new StringBuilder();
        while (l1 >= 0 || l2 >= 0) {
            char c1 = (l1 >= 0) ? a.charAt(l1) : '2';
            char c2 = (l2 >= 0) ? b.charAt(l2) : '2';
            char temp = '0';
            if (c) {
                if (c1 == '1' && c2 == '1') {
                    temp = '1';
                } else if (c1 == '1' || c2 == '1') {
                    temp = '0';
                } else {
                    temp = '1';
                    c = false;
                }
            } else {
                if (c1 == '1' && c2 == '1') {
                    temp = '0';
                    c = true;
                } else if (c1 == '1' || c2 == '1') {
                    temp = '1';
                } else {
                    temp = '0';
                }
            }
            res.insert(0, temp);
            l1--;
            l2--;
        }
        if (c) res.insert(0, '1');
        return res.toString();
    }
}