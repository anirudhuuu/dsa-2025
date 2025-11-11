package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Breadth First Search (BFS)
 * =============================
 * BFS is a graph traversal algorithm that starts from a given source node
 * and explores all nodes level by level. It visits all immediate neighbors
 * first before moving to the next layer of nodes.
 *
 * Time Complexity: O(V + E)
 * - V = number of vertices
 * - E = number of edges
 * BFS processes every vertex and every edge at most once.
 *
 * Space Complexity: O(V)
 * - Due to the queue used for level-order traversal
 * - Plus the visited array (or set) used to mark nodes
 */
public class BreadthFirstSearch03 {
    /**
     * BFS from a given start node.
     *
     * @param V             number of vertices (0...V-1)
     * @param adjacencyList adjacency list
     * @return BFS order from start
     */
    List<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adjacencyList) {
        List<Integer> bfsOrder = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        // Pass the starting node into queue
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            Integer element = queue.poll();
            bfsOrder.add(element);

            // Ask the picked node, who are the neighbors?
            for (Integer neighbor : adjacencyList.get(element)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return bfsOrder;
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

        // Perform BFS on the adjacency list
        List<Integer> bfs = new BreadthFirstSearch03().bfsOfGraph(10, adj);
        System.out.println("BFS Traversal: " + bfs);
    }
}
