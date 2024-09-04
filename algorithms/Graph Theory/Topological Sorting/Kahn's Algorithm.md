# Kahn's Algorithm for Topological Sorting
## Topological Sorting
Understand what topological ordering means and why it is needed [here](Simple%20Topological%20Sorting.md)

## Difference between Kahn's Algorithm and DFS based approach:
1. DFS based method cannot identify if cycle is present or not in the graph, where Kahn's algorithm can identify the cycle in the graph.
2. Kahn's algorithm uses BFS approach instead of DFS
3. Kahn's Algorithm requires us to maintain a data structure that stores the degree of each node. Degree meaning the dependencies.

## Intuition behind the Kahn's Algorithm
1. We repeatedly remove the nodes without dependencies (zero degree) from the graph and add them to topological ordering list from left to right.
2. As nodes without dependencies are removed from the graph, new nodes with zero dependencies will be added to the queue to do the same
3. We do it till we process all the nodes in the graph, or we find a cycle.
4. If a graph contains cycle, we will have an empty queue with some of the nodes need to be processed.

## Pseudocode
> Assumption is the input *graph* is an adjacency list.
```Java
function findTopologicalOrder(graph):
    n = g.size()
    degree = [0] * n // Array of size n with zeros in it.
    
    //this creates 
    for(int i = 0 -> n-1):
        for (child in graph[i].children):
            degree[child] = degree[child] + 1
    
    queue = Queue() // This queue will hold each nodes that do not have any incoming edges
    for (int i = 0 -> n-1):
        if (degree[i] == 0): queue.enqueue(graph[i])

    order = list()
    index = 0
    while (queue is not empty):
        curr = queue.dequeue()
        order.append(curr)
        index = index + 1
        for child of curr:
            degree[child] = degree[child] - 1
            if degree[child] == 0: queue.enqueue(graph[child])
    if index != n: return null // found a cycle
    return order // correct order
```

## Reference
1. [Topological Sort | Kahn's Algorithm | Graph Theory](https://www.youtube.com/watch?v=cIBFEhD77b4)
2. [Kahn’s algorithm for Topological Sorting](https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/)