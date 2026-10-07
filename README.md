# Data Structure & Graph Performance Analyzer

## Project Description
A Java console-based application that demonstrates Array, Stack, Queue, Linked List,
Searching (Linear vs Binary), Graph (BFS / DFS) and a performance comparison of
algorithms (steps and execution time). Built for CIT300 Graded Practical Assignment 2.

## Team Members

### Member 1 & 5
- **Student Name:** Fathima (J.Fathima)
- **Student ID:** 23DA2-0570
- **Assigned Responsibility:** Array, Searching, Performance Comparison, Main Menu, Integration
- **Individual Contribution:**
  - Implemented `ArrayOperations` (insert, delete, search, display)
  - Implemented `SearchOperations` (Linear Search and Binary Search with step counting)
  - Implemented `PerformanceAnalyzer` (steps + execution time table)
  - Created `Main` menu with input validation and integrated all modules
  - Tested the complete system

### Member 2
- **Student Name:** Risny (N.Risny)
- **Student ID:** 23DA2-0694
- **Assigned Responsibility:** Stack and Queue
- **Individual Contribution:**
  - Implemented `MyStack` (push, pop, peek, display, overflow/underflow handling)
  - Implemented `MyQueue` as a circular array (enqueue, dequeue, front, display)
  - Tested and integrated with the main application

### Member 3
- **Student Name:** Nameek (MN.Nameek)
- **Student ID:** 23DA2-0800
- **Assigned Responsibility:** Linked List
- **Individual Contribution:**
  - Implemented `MyLinkedList` with a `Node` class
  - Implemented insert (beginning/end), delete, search, display
  - Tested and integrated with the main application

### Member 4
- **Student Name:** Thasnim (MF.Thasnim)
- **Student ID:** 23DA2-0556
- **Assigned Responsibility:** Graph Component
- **Individual Contribution:**
  - Implemented `Graph` using an adjacency list
  - Implemented add vertex, add edge, display graph
  - Implemented BFS (queue) and DFS (recursion) traversal with step counting
  - Tested graph functionality and integrated it with the main application

## Technologies Used
- Java (JDK 17 or later)
- Git & GitHub
- Visual Studio Code

## Main System Features
- Array, Stack, Queue and Linked List operations with empty/full handling
- Linear Search vs Binary Search comparison (steps and time)
- Undirected graph with BFS and DFS traversal
- Performance comparison table and "Display All Results"
- Input validation on every menu and input

## Complexity Summary
| Operation | Complexity |
|---|---|
| Linear Search | O(n) |
| Binary Search | O(log n) (sorted data) |
| Stack push/pop/peek | O(1) |
| Queue enqueue/dequeue | O(1) |
| Linked List insert at beginning | O(1) |
| Linked List insert at end / delete / search | O(n) |
| BFS / DFS | O(V + E) |

## How to Run
**Command line**
```
cd src
javac *.java
java Main
```
**VS Code**
1. File > Open Folder > select `DS-Graph-Performance-Analyzer`
2. Install "Extension Pack for Java"
3. Open `src/Main.java` and click **Run** above `main`
# DS-Graph-Performance-Analyzer