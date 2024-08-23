/**
 * LeetCode - 155 - https://leetcode.com/problems/min-stack/description/
 *
 * Problem Statemenet:
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 * Approch:
 * 1. Two stacks. One stack does push and pop similar like normal stack. Another stack is to store upcoming minimums
 * 2. For example:
 *  I have a push of let's [1, 3, -2, 4, 1, -5, 2, 0]
 *  My min stack will look like: [1, -2, 1, -5]
 *  Every time I will do pop, it will be popped from stack as usual. But we will only pop the min if the main stack's
 *  pop is same.
 *  Main Pops = [0, 2, -5, 1, 4, -2, 3, 1]
 *  Min Pops =  [-, -, -5, 1, -, -2, -, 1]
 */

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else if (val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (minStack.peek().equals(stack.peek())) minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */