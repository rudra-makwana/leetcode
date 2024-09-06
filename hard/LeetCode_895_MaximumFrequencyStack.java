/**
 * LeetCode - 895 - https://leetcode.com/problems/maximum-frequency-stack/description/
 *
 * We need to create a data structure that can return the number with highest frequency. If two values have same freq
 * then return the last added elements.
 *
 * Now freq is important meaning we need to keep track of each elements' frequencies that means we need one hashtable
 * at least. Val as key and freq as value.
 *
 * Now we need to use a stack that stores data ordered manner but for each freq. Again we can use the hashtable for it.
 * Being freq as key and stack as value.
 *
 * maxFreq to tell us what is the highest freq we habe noticed so far while adding and popping the data.
 */


class FreqStack {
    Map<Integer, Integer> freqs;
    Map<Integer, Deque<Integer>> stacks;
    int maxFreq;

    public FreqStack() {
        this.freqs = new HashMap<>();
        this.stacks = new HashMap<>();
        this.maxFreq = 0;
    }

    public void push(int val) {
        int freq = freqs.getOrDefault(val, 0) + 1;
        if (freq > maxFreq) maxFreq = freq; // if the freq is bigger than the maxFreq then update maxFreq to freq

        // stacks.computeIfAbsent(freq, stack -> new ArrayDeque<>()).push(val) can be used instead following three lines
        Deque<Integer> stack = stacks.getOrDefault(freq, new ArrayDeque<>()); // get a stack relevant to the freq
        stack.addLast(val); // add the freq value to last
        stacks.put(freq, stack); // save the stack in stacks map
    }

    public int pop() {
        int res = stacks.get(maxFreq).removeLast();
        freqs.put(res, freqs.get(res) - 1);
        if (stacks.get(maxFreq).size() == 0) maxFreq--;
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */