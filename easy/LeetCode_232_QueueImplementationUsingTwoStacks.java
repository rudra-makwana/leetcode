/**
 * LeetCode - 232 - https://leetcode.com/problems/implement-queue-using-stacks/description/
 */
class MyQueue {
    public Stack<Integer> queue;
    private Stack<Integer> buffer;

    public MyQueue() {
        queue = new Stack<Integer>();
        buffer = new Stack<Integer>();
    }

    public void push(int x) {
        while (!queue.empty()) {
            buffer.push(queue.pop());
        }
        buffer.push(x);
        while (!buffer.empty()) {
            queue.push(buffer.pop());
        }
    }

    public int pop() {
        return queue.pop();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */