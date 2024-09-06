/**
 * LeetCode - 17 - https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * My initial approach using backtracking:
 * 1. Create a hashmap that maps characters to the keypad number
 * 2. Create an empty list of strings that will store the possible combinations
 * 3. We create a helper function that takes the main digit element
 */

class Solution {
    Map<Integer, List<Character>> key;
    private List<String> result;

    Solution(){
        result = new ArrayList<>();
        key = new HashMap<>();
        char currChar = 'a';
        for (int i = 2; i < 10; i++) {
            List<Character> temp = new ArrayList();
            int totalC = 3;
            if (i == 7 || i == 9) totalC = 4;
            for(int j = 0; j < totalC; j++) temp.add(currChar++);
            key.put(i, temp);
        }
    }

    private void createCombinations(String digits, List<Character> curr) {
        if (digits.length() == 0) return;
        if (curr.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : curr) {
                sb.append(ch);
            }
            result.add(sb.toString());
            return;
        }
        char currChar = digits.charAt(curr.size());
        List<Character> chars = key.get(Character.getNumericValue(currChar));
        for (char c: chars) {
            curr.add(c);
            createCombinations(digits, curr);
            curr.remove(curr.size()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        createCombinations(digits, new ArrayList<Character>());
        return result;
    }
}