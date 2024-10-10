/**
 * LeetCode - 14 - https://leetcode.com/problems/longest-common-prefix/description/
 *
 * My approach to iterate over each index of all the strings together till we find a mismatch of characters
 *
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();

        outerloop:
        for(int i = 0; ; i++) {
            char c = ' ';
            for (String str: strs) {
                if (i == str.length()) break outerloop;
                if (c == ' ') c = str.charAt(i);
                if (c != str.charAt(i)) break outerloop;
            }
            res.append(c);
        }

        return res.toString();
    }
}


/** Approach using trie data structure

 class Trie {
 char c;
 Map<Character, Trie> nexts;

 Trie(char c) {
 this.c = c;
 this.nexts = new HashMap<>();
 }

 void createFullTrie(String word) {
 Trie node = this;
 for (int i = 0; i < word.length(); i++) {
 char c = word.charAt(i);
 if (!node.nexts.containsKey(c)) node.nexts.put(c, new Trie(c));
 node = node.nexts.get(c);
 }
 }
 }

 class Solution {
 private String getPrefix(Trie node, String word) {
 String res = new String();
 for (int i = 0; i < word.length(); i++) {
 char c = word.charAt(i);
 if (!node.nexts.containsKey(c)) return res;
 res += c;
 node = node.nexts.get(c);
 }
 return res;
 }

 public String longestCommonPrefix(String[] strs) {
 Trie root = new Trie(' ');
 root.createFullTrie(strs[0]);
 String res = strs[0];
 for(int i = 1; i < strs.length; i++) {
 String temp = getPrefix(root, strs[i]);
 if (temp.length() < res.length()) res = temp;
 }
 return res;
 }
 }

 */