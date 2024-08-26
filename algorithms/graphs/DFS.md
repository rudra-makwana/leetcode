# DFS - Depth First Search Algorithm
This is one of the common graph traversal approaches similar like tree data structure. But unlike trees, a graph can be acyclic. To avoid processing same node again, we need to keep track of already visited node.

In this traversal method, we identify the finishes the branch we are working with first before going to bext branch of the currently selected node. So we will be finishing the lowest level of the branch first before finishing the sibling nodes in the same level.

> A graph can have more than one DFS paths than the trees which has only one DFS traversal.

### Example
**Input**:\
V = 5 , E = 5
```
#
Edges = { 
    {1, 2},
    {1, 0},
    {0, 2},
    {2, 3},
    {2, 4}
}
```
**Graph**:
![Graph image](https://media.geeksforgeeks.org/wp-content/uploads/20240809162859/Input_undirected_Graph.webp)

**Output**: 1 -> 0 -> 2 -> 3 -> 4

**Explanation**:
1. Start at 1. Mark as visited. Ouput = 1
2. Go to child elements [0 & 2]. Go to 0.
3. Mark 0 as visited. Output => 1 -> 0
4. Go to child elements of 0. [1 & 2]
5. 1 is already visited so move to 2.
6. Mark 2 as visited. Output: 1 -> 0 -> 2
7. And go to 2's child nodes[1, 3, 4]
8. 1 is visited hence 3 is selected. Mark 3 is visited. Output: 1 -> 0 -> 2 -> 3
9. Same check for 3's childs. 2 is visited and no other child node.
10. Come to 2's another child that is 4. Mark it as visited. Output: 1 -> 0 -> 2 -> 3 -> 4
11. No child of 4 needs to be visited as 2 is the only child and already been visited.
12. Come back to 2.
13. No child needs to be visited here as well. So go to 0.
14. Same for 0 so go back to 1.
15. 0 & 2 both are visited so we got the answer.

> **DFS can be implemented using recursion or stacks**

## DFS Algo:

### Node data structure
```java
import java.util.ArrayList;

// Let's say our graph data structure looks like this
class Node {
    int val;
    List<Node> children;

    public Node(int val) {
        this.val = val; // No children. We cannot traverse any node from here.
        this.children = new ArrayList(); // empty list
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
```

### Java pseudo code implementation using recursion.

```
class DFS {
    private Set<Node> visited; // To avoid already visited node again

    private void dfsTraverse(Node root) {
        if (root == null || !visited.add(root)) return;
        print("Visited element: " + root.val);
        for (Node child : root.children) {
            dfsTraverse(child);
        }
    }

    public void printNodesInDFSOrder(Node root) {
        visited = new HashSet<Node>();
        dfsTraverse(root);
    }
}
```