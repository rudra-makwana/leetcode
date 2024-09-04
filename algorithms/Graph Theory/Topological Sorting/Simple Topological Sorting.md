# Simple Topological Sorting
Topological sorting/ordering algorithm is an approach to order each node of a **Directed Acyclic Graph**, where for each directed edge from ***Node A*** to ***Node B***, **A** will always come before **B**.

The topological sorting can be done in the O(E+V), where E is number of edges and V is number of vertices.

> Directed graph with a cycle or non-directed (bidirectional) graphs cannot have a topological order

> Tree data structures can have a topological ordering.

#### Topological ordering can be useful in the following real life situations:
Many real world problems can be represented as a directed graph where one event/situation must occur before the other. Some situations are mentioned below:
1. **School Course Prerequisites**: Before taking a class B, we need to finish all the prerequisites of course B. Prerequisites of course B can also have their own prerequisites and they must be completed before we finish prerequisites of course B.
2. **Program Dependency**: When building a program, we need to build its dependencies first and so on.
3. **Event Scheduling** and so on...

## Algorithm:
1. n = number of nodes
2. Create a list to store values/vertices that are already visited
3. Result list that will store an actual order of the graph.
4. itearte over each node:
   1. if node visited then select the next node
   2. if node has no children to visit then add the node to the right most available position of the order list
   3. else apply dfs on the children one by one
   4. if all the children and their descendants are added in the result list, then add the current selected element and mark it as visited
5. return the result list

## Pseudo code
### DFS Function
```
func dfs(currentNode, visited, topologicalOrder):
   if (currentNode in visited): return topologicalOrder
   
   visited.add(currentNode);
   children = currentNode.children
   
   for child in children:
      topologicalOrder = dfs(child, visited, topologicalOrder)
   
   topologicalOrder[lastAvailableIndex] = currentNode
   lastAvailableIndex = lastAvailableIndex - 1
   return topologicalOrder
```

### Topological Sort Function
```
global visited
global lastAvailableIndex

function topologicalSort(graph):
   n = number of nodes in graph
   lastAvailableIndex = n-1
   visited = Set()
   ordering = List(size=n) 
   
   for(i = 0; i < n; i++):
      if (graph[i] not in visited):
         order = dfs(graph[i], visited, order)
   return order
```

## Reference
1. [YouTube - Topological Sort Algorithm | Graph theory](https://www.youtube.com/watch?v=eL-KzMXSXXI)
2. [Wikipedia - Topological sorting](https://en.wikipedia.org/wiki/Topological_sorting)