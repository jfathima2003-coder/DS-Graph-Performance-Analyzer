import java.util.*;
import java.util.stream.Collectors;

/**
 * Undirected graph using an adjacency list, with BFS and DFS traversal.
 * BFS/DFS return the number of steps = vertices visited + edges examined.
 * Both are O(V + E).
 * Owner: Thasnim (Member 4)
 */
public class Graph {
    // TreeMap keeps vertices sorted so the output is easy to read.
    private final Map<Integer, List<Integer>> adjacencyList = new TreeMap<>();
    private int steps;

    public boolean isEmpty() { return adjacencyList.isEmpty(); }
    public boolean hasVertex(int v) { return adjacencyList.containsKey(v); }
    public int vertexCount() { return adjacencyList.size(); }

    /** Smallest vertex number (used as default start for traversals). */
    public int firstVertex() {
        return adjacencyList.keySet().iterator().next();
    }

    public boolean addVertex(int v) {
        if (hasVertex(v)) {
            System.out.println("Vertex " + v + " already exists.");
            return false;
        }
        adjacencyList.put(v, new ArrayList<>());
        System.out.println("Vertex " + v + " added.");
        return true;
    }

    public boolean addEdge(int u, int v) {
        if (!hasVertex(u) || !hasVertex(v)) {
            System.out.println("Both vertices must exist first. Add the missing vertex.");
            return false;
        }
        if (u == v) {
            System.out.println("Self-loops are not allowed.");
            return false;
        }
        if (adjacencyList.get(u).contains(v)) {
            System.out.println("Edge " + u + " - " + v + " already exists.");
            return false;
        }
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
        Collections.sort(adjacencyList.get(u));
        Collections.sort(adjacencyList.get(v));
        System.out.println("Edge " + u + " - " + v + " added.");
        return true;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("Adjacency List:");
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    // ---------------- BFS (uses a Queue) ----------------
    public int bfs(int start) {
        return bfs(start, true);
    }

    public int bfs(int start, boolean print) {
        if (!hasVertex(start)) {
            if (print) System.out.println("Vertex " + start + " does not exist.");
            return -1;
        }
        steps = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            steps++;
            order.add(current);
            for (int neighbour : adjacencyList.get(current)) {
                steps++;
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        if (print) {
            System.out.println("BFS order: " + toText(order));
            System.out.println("Steps: " + steps);
        }
        return steps;
    }

    // ---------------- DFS (recursion = call stack) ----------------
    public int dfs(int start) {
        return dfs(start, true);
    }

    public int dfs(int start, boolean print) {
        if (!hasVertex(start)) {
            if (print) System.out.println("Vertex " + start + " does not exist.");
            return -1;
        }
        steps = 0;
        Set<Integer> visited = new HashSet<>();
        List<Integer> order = new ArrayList<>();
        dfsVisit(start, visited, order);
        if (print) {
            System.out.println("DFS order: " + toText(order));
            System.out.println("Steps: " + steps);
        }
        return steps;
    }

    private void dfsVisit(int current, Set<Integer> visited, List<Integer> order) {
        visited.add(current);
        order.add(current);
        steps++;
        for (int neighbour : adjacencyList.get(current)) {
            steps++;
            if (!visited.contains(neighbour)) {
                dfsVisit(neighbour, visited, order);
            }
        }
    }

    private String toText(List<Integer> order) {
        return order.stream().map(String::valueOf).collect(Collectors.joining(" -> "));
    }

    /** A ready-made sample graph (used when the user has not built one). */
    public static Graph createSample() {
        Graph g = new Graph();
        int[] vertices = {1, 2, 3, 4, 5, 6, 7, 8};
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {5, 8}, {6, 8}};
        System.out.println("(Building sample graph...)");
        for (int v : vertices) g.adjacencyList.put(v, new ArrayList<>());
        for (int[] e : edges) {
            g.adjacencyList.get(e[0]).add(e[1]);
            g.adjacencyList.get(e[1]).add(e[0]);
        }
        for (List<Integer> list : g.adjacencyList.values()) Collections.sort(list);
        return g;
    }
}
