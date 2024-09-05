# Heap Data Structure
A heap is a special kind of binary tree which satisfies a specific heap property. This property explains what will be the relationship between the node and its parent node.

There are two types of properties:
1. #### **Min Heap**:
    In a min heap data structure, the parent node's value will be always less or equal to its children. This means the root node of a tree will always have the smallest element in the tree.
    This data structure is helpful for the algorithms which require to access smallest elements, such as ***Priority Queues*** and ***Dijkstra's shortest path algorithm***.

2. #### **Max Heap**
    A max heap is opposite of min heap. The parent node's value will be greater or equal to its children nodes' values. This means largest value in the tree would be on top/root of the tree.
    This is useful in scenarios where the largest values need to be accessed quickly, such as ***Heap Sort*** or ***Priority Queues where higher numbers have higher priority***.

### Real life applications
* #### Priority Queues:
    A priority queue is a data structure where each element has a priority. Elements with higher priorities are served before the elements with smaller priorities. Heap is an efficient way of implementing the priority queue, where insertion and deletion is of ***O(n * long(n))***.
* #### Heap Sort:
    This is one of the popular sorting method that uses a heap to sort elements. It uses a max heap using an input array, and then we repeatedly extracts the maximum element to make the sorted list.
* #### Scheduling Algorithm:
    In OS, heaps can be seen in the job scheduling or managing processes in a priority queue, ensuring the most critical job is finished first.
* #### Graph Algorithms:
    Algorithms like Dijkstra's shortest path or Prim's minimum spanning tree uses heaps to select next vertex efficiently with the smallest or largest edge weights.

## Implementation of Min Heap Data Structure

```java
class Heap {
    private int[] heap; // This will be heapify array
    private int size; // Number of elements stored in the array
    private int maxSize; // Capacity of the array
    
    private static final int FRONT = 1;
    
    public Heap(int maxSize) {
        this.size = 0; // No element in the beginning hence zero
        this.maxSize = maxSize; // Set the capacity of the element
        this.heap = new int[this.maxSize + 1]; // Extra 1 to compare for insertion on empty array
        heap[0] = Integer.MIN_VALUE; // If array is empty then it would be the comparison value
    }
    
    private int parent(int pos) {
        return pos/2; // parent node index of the current pos
    }
    
    private int leftChild(int pos) {
        return (2 * pos); // left child of a current node
    }
    
    private int rightChild(int pos) {
        return leftChild(pos) + 1; // right child would be on the next index of left child
    }
    
    private boolean isLeaf(int pos) {
        if (pos > size/2) return true; // leaf node will be always on the right side of the middle of the filled heap array in complete binary tree.
        return false;
    }
    
    private void swap(int fpos, int spos) {
        int temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
    }
    
    private void heapify(int pos) { // min heap
        if (!isLeaf(pos)) { // if we are at leaf node then we don't have to perform the heap operation
            int swapPos = pos;
            int rightChildPos = rightChild(pos);
            int leftChildPos = leftChild(pos);
            if (rightChildPos <= size){ // right node might not be available
                // if left & right node is available then we need to find the position of smallest element among them
                swapPos = heap[leftChildPos] < heap[rightChildPos] ? leftChildPos : rightChildPos; 
            } else {
                // if only left available get left's position
                swapPos = leftChildPos;
            }
            
            if (heap[pos] > heap[leftChildPos] || heap[pos] > heap[rightChildPos]) {
                // compare the current element with left's and right's values if the current is bigger then swap
                swap(pos, swapPos);
                heapify(swapPos);
            }
        }
    }
    
    public void insert(int value) {
        if (size >= maxSize) return; // the heap is full then do nothin. In proper heap implementation it will throw an error
        
        heap[++size] = element; // increase the current size of heap array and add an element to the next available position 
        int curr = size;
        
        while(heap[curr] < heap[parent(curr)]) { // compare the added element with its parent node. Parent must be smaller than its children. If not, then we need to correct it.
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }
    
    public int remove() {
        // Simple swapping and reducing the size.
        int elem = heap[FRONT]; // temporary swapping buffer variable
        heap[front] = heap[size--]; // last element will  be added to the front and size will be reduced by 1.
        heapify(FRONT); // heapify the array to make it correct min heap
        return elem; // return the removed element
    }
    
    public int[] get() {
        return this.heap;
    }
    
    public int get(int pos) {
        if (pos > size) return -1;
        return this.heap[pos];
    }
}
```

## Reference
1. [YouTube - Heaps in 3 minutes](https://www.youtube.com/watch?v=0wPlzMU-k00)
2. [YouTube - Heap Data Structure Tutorial | Min Heap and Max Heap Explained | C Language Tutorial](https://www.youtube.com/watch?v=m5oGahPgFL0)
3. [GeeksForGeeks - Min Heap in Java](https://www.geeksforgeeks.org/min-heap-in-java/)