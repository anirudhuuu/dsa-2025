package graphs;

import java.util.ArrayList;
import java.util.List;

/*
 * Depth First Search (DFS)
 * =============================
 * DFS is a graph traversal algorithm that starts from a given source node
 * and explores as deep as possible along each branch before backtracking.
 * It fully explores one path, then returns and explores the next unvisited path.
 *
 * Time Complexity: O(V + E)
 * - V = number of vertices
 * - E = number of edges
 * DFS visits every vertex and edge at most once.
 *
 * Space Complexity: O(V)
 * - Due to the recursion stack in the worst case
 * - Plus the visited array used to track explored nodes
 */
public class DepthFirstSearch04 {
    /*
     * Performs a Depth First Search (DFS) starting from the given node.
     *
     * @param node          current node being explored
     * @param visited       boolean array tracking which nodes have been visited
     * @param adjacencyList graph represented as an adjacency list
     * @param result        list collecting the DFS traversal order
     */
    void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList, List<Integer> result) {
        // mark the current operating node as visited
        visited[node] = true;
        result.add(node);

        // find neighbors of operating node
        for (Integer neighbour : adjacencyList.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, adjacencyList, result);
            }
        }
    }

    /*
     * Performs DFS traversal for the entire graph.
     * Works even if the graph has multiple disconnected components.
     *
     * @param V             number of nodes in the graph (0 to V-1)
     * @param adjacencyList adjacency list of the graph
     * @return DFS traversal order
     */
    List<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adjacencyList) {
        List<Integer> dfsOrder = new ArrayList<>();
        boolean[] visited = new boolean[V];

        // start DFS from node 1
        // starting node, visited array, adjacency list, final result
        dfs(1, visited, adjacencyList, dfsOrder);

        return dfsOrder;
    }

    static void main() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        /*
         * Graph
         * --------
         * 0 -- {}
         * 1 -- {2, 6}
         * 2 -- {1, 3, 4}
         * 3 -- {2}
         * 4 -- {2, 5}
         * 5 -- {4, 8}
         * 6 -- {1, 7, 9}
         * 7 -- {6, 8}
         * 8 -- {5, 7}
         * 9 -- {6}
         */
        for (int i = 0; i < 10; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges
        adj.get(1).add(2);
        adj.get(1).add(6);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(2);
        adj.get(4).add(2);
        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(5).add(8);
        adj.get(6).add(1);
        adj.get(6).add(7);
        adj.get(6).add(9);
        adj.get(7).add(6);
        adj.get(7).add(8);
        adj.get(8).add(5);
        adj.get(8).add(7);
        adj.get(9).add(6);

        // Perform DFS on the adjacency list
        List<Integer> dfs = new DepthFirstSearch04().dfsOfGraph(10, adj);
        System.out.println("DFS Traversal: " + dfs);
    }
}
