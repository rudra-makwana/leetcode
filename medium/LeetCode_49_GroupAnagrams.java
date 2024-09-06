/**
 * LeetCode - 49 - https://leetcode.com/problems/group-anagrams/description/
 *
 */

class Solution {

    private String createKey(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                freq[i]--;
                char c = (char)(i + 'a');
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> grouped = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String sorted = createKey(strs[i]);
            List<String> list = grouped.getOrDefault(sorted, new ArrayList<>());
            list.add(strs[i]);
            grouped.put(sorted, list);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> pair: grouped.entrySet()){
            res.add(pair.getValue());
        }
        return res;
    }
}