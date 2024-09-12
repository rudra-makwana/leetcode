/**
 * LeetCode - 295 - https://leetcode.com/problems/find-median-from-data-stream/description/
 *
 * Idea:
 * We can use two heap data structures:
 * 1. Min Heap - that will store the bigger half portion of the data being minimum on top of the heap
 * 2. Max Heap - that will store the smaller half portion of the data being maximum on top of the heap
 *
 * These two data structures will keep the possible median(s) on top of the heaps.
 *
 * Algorithm:
 * 1. initialize the heaps one with reverseorder
 * 2. addNum function:
 *  a. Add a value to maxHeap first to see if it belongs to bigger part of the data we have seen so far. If it's not then
 *  it will stay at top of the heap.
 *  b. Remove the top of the max heap and add it to minHeap data. This will bring biggest of smaller bound data in the
 *  bigger half.
 *  c. Now check if maxHeap size is smaller than minHeap size that means we need to transefer top of min heap to max
 *  heap. This will ensure that minHeap will be same as maxHeap or bigger by 1 elements only (this will happen in odd
 *  data case)
 *
 * 3. getMedian function:
 *  a. if minHeapSize > maxHeapSize meaning we have odd number of data so we can simply return the top of the minHeap
 *  b. else we can take a sum of minHeap's top and maxHeap's top and then divide the sum by 2 and return the final value
 */

class MedianFinder {
    private Queue<Integer> minHeap, maxHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // this will be used to store smaller values than the median
        minHeap = new PriorityQueue<>(); // this will store bigger values than the median where smallest will be on top in the heap
    }

    public void addNum(int num) {
        Queue<Integer> min = minHeap;
        Queue<Integer> max = maxHeap;
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.remove());
        }
        min = minHeap;
        max = maxHeap;
        return;
    }

    public double findMedian() {
        Queue<Integer> min = minHeap;
        Queue<Integer> max = maxHeap;
        int minSize = minHeap.size(), maxSize = maxHeap.size();
        if (minSize < maxSize) return (double)maxHeap.peek();
        return (double)(minHeap.peek() + maxHeap.peek()) * 0.5;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */