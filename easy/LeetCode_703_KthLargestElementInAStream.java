/**
 * LeetCode - 703 - https://leetcode.com/problems/kth-largest-element-in-a-stream
 */


class KthLargest {
    Queue<Integer> scores;
    int k;

    public KthLargest(int k, int[] nums) {
        this.scores = new PriorityQueue<>();
        this.k = k;
        for (int num: nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        scores.offer(val);
        if (scores.size() > k) scores.remove();
        return scores.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */


/**
 * Python:
 *
 * import heapq
 *
 * class KthLargest:
 *
 *     def __init__(self, k: int, nums: List[int]):
 *         self.scores = []
 *         self.capacity = k
 *         for num in nums: self.add(num)
 *
 *     def add(self, val: int) -> int:
 *         heappush(self.scores, val)
 *         if (len(self.scores) > self.capacity): heappop(self.scores)
 *         return self.scores[0]
 */