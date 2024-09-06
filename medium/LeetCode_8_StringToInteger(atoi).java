/**
 *
 * LeetCode - 8 - https://leetcode.com/problems/string-to-integer-atoi/description/
 *
 * Simple approch is to use stack or doubly linked list (deque)
 *
 */

class Solution {

    int[] digits;

    Solution() {
        digits = new int[10];
        for(int i = 0; i < 10; i++) {
            digits[i] = i;
        }
    }

    private Pair<Boolean, Deque<Integer>> createStackOfDigits(String s) {
        Deque<Integer> queue = new LinkedList<>();
        boolean isNegative = false;
        boolean isStart = false;
        for (int i = 0; i < s.length() && queue.size() < 12; i++) {
            char c = s.charAt(i);
            if (!isStart && c == '-') {
                isNegative = true;
                isStart = true;
            } else if (!isStart && c == '+') {
                isStart = true;
            } else if (!isStart && c == ' ') {
                continue;
            } else if (queue.size() == 0 && c == '0') {
                isStart = true;
                continue;
            } else if ((c-48)>= 0 && (c-48) < 10) {
                isStart = true;
                queue.addLast(digits[c-48]);
            } else {
                break;
            }
        }
        return new Pair(isNegative, queue);
    }

    public int myAtoi(String s) {
        Pair<Boolean, Deque<Integer>> pair = createStackOfDigits(s);
        boolean isNegative = pair.getKey();
        Deque<Integer> q = pair.getValue();
        if (q.size() > 10 || (q.size() == 10 && q.peekFirst() > 2)) {
            if (isNegative) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }

        int i = 0, sum = 0;
        while(!q.isEmpty()) {
            if (i == 9 && q.peekLast() > 2) {
                if (isNegative) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            int diff = Integer.MAX_VALUE - sum;
            int next = q.removeLast() * (int) Math.pow(10, i);
            if (diff < next) {
                // sum = Integer.MAX_VALUE;
                // if (isNegative) sum += 1;
                if (isNegative) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            sum += next;
            i++;
        }
        return isNegative ? -1 * sum : sum;
    }
}