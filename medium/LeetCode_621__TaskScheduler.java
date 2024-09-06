/**
 * LeetCode - 621 - https://leetcode.com/problems/task-scheduler/
 */


/**
 *
 * Approach 2 - Filling the slots and sorting
 *
 * Intuition: we need to find the minimum time required to finish all the tasks. The constraint is same task must
 * be executed after n intervals which is a cooling period.
 *
 * We should first schedule the task with highest freq with n empty slots apart to let the machine cool down. This will
 * minimize the time interval. After that we try to fill the remaining empty slots with other tasks.
 *
 */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int size = tasks.length;
        for(int i =0; i < size; i++) {
            freq[tasks[i] - 'A']++; // 'A' because the task is always uppercase letter
        }
        Arrays.sort(freq); // Sorting the freq based on ascending order

        int maxFreq = freq[25];
        int idleSlots = (maxFreq - 1) * n; // maxFreq - 1 because if I have 2 As and n = 2 => I will need (2 - 1) * 2 = 2 slots A _ _ A

        for (int i = 24; i >=0 && freq[i] > 0; i--) {
            idleSlots -= Math.min(maxFreq-1, freq[i]);
        }

        return idleSlots > 0 ? size + idleSlots : size;
    }
}

/**
 *
 * Approach 1 - Using a Priority Queue (Max Heap) - Greed algorithm
 *
 * Intuition:
 * 1. First we calculate the frequency array of all the tasks. How many time each task appears.
 * 2. Create a max heap of this frequencies using a priority queue
 * 3. Apply greedy logic to select the task with highest freqencies in the heap till queue is empty.
 * 4. Cycle would be n + 1 where n is a cooling period. 1 is for the execution of actual task.
 */

//class Solution {
//    public int leastInterval(char[] tasks, int n) {
//        int[] freq = new int[26];
//        int size = tasks.length;
//        for(int i =0; i < size; i++) {
//            freq[tasks[i] - 'A']++; // 'A' because the task is always uppercase letter
//        }
//        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
//        // Collections.reverseOrder() to convert it to max heap
//        for (int i = 0; i < 26; i++) {
//            if (freq[i] > 0) q.offer(freq[i]);
//        }
//
//        int time = 0;
//        while(!q.isEmpty()) {
//            int cycle = n+1;
//            List<Integer> store = new ArrayList<>();
//            int taskCount = 0;
//
//            while (cycle > 0 && !q.isEmpty()) {
//                int currFreq = q.poll(); // popped freq won't be added until the cycle is completed
//                if (currFreq > 1) store.add(currFreq-1);
//                taskCount++;
//                cycle--;
//            }
//
//            for(Integer i: store) q.offer(i); // We have passed the cooling period here so add them back to the heap
//
//            time += (q.isEmpty()) ? taskCount : n + 1; // Add the taskCount if q is empty or (n+1) to the time elapsed
//        }
//        return time;
//    }
//}