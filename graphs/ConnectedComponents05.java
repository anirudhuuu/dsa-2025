package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Connected Components
 * =====================
 * Given a undirected Graph consisting of V vertices numbered from 0 to V-1 and E edges. The ith edge is
 * represented by [ai,bi], denoting a edge between vertex ai and bi. We say two vertices u and v belong
 * to a same component if there is a path from u to v or v to u. Find the number of connected components in the graph.
 * <p>
 * A connected component is a subgraph of a graph in which there exists a path between any two vertices,
 * and no vertex of the subgraph shares an edge with a vertex outside the subgraph.
 * <p>
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 * where, V denotes the number of nodes, E denotes the number of edges
 */
public class ConnectedComponents05 {
    /**
     * Perform BFS on a given node
     */
    void bfs(int node, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited) {
        visited[node] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Integer element = queue.poll();

            for (Integer neighbor : adjacencyList.get(element)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    /**
     * Find number of connected components in an undirected graph
     */
    int findNumberOfComponents(int V, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                bfs(i, adjacencyList, visited);
            }
        }

        return count;
    }

    static void main() {
        int V = 7;

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(0, 1)));
        edges.add(new ArrayList<>(List.of(1, 2)));
        edges.add(new ArrayList<>(List.of(2, 3)));
        edges.add(new ArrayList<>(List.of(4, 5)));

        int ans = new ConnectedComponents05().findNumberOfComponents(V, edges);
        System.out.println("Number of connected components: " + ans);
    }
}
