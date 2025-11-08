package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Number of provinces
 * =====================
 * Given an undirected graph with V vertices. Two vertices u and v belong to a
 * single province if there is a path from u to v or v to u. Find the number of
 * provinces. The graph is given as an n x n matrix adj where adj[i][j] = 1 if
 * the ith city and the jth city are directly connected, and adj[i][j] = 0
 * otherwise.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other
 * cities outside the group.
 * <p>
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */
public class NoOfProvinces08 {
    void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[node] = true;

        for (int neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adjList, visited);
            }
        }
    }

    int numProvinces(int[][] adj) {
        // no of nodes
        int V = adj.length;

        // keeping track of visited nodes
        boolean[] visited = new boolean[V];

        // convert adjacency matrix to adjacency list
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj[i][j] == 1 && i != j) {
                    adjacencyList.get(i).add(j);
                    adjacencyList.get(j).add(i);
                }
            }
        }

        int noOfProvinces = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                noOfProvinces += 1;
                dfs(i, adjacencyList, visited);
            }
        }

        return noOfProvinces;
    }

    static void main() {
        int[][] adj = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };

        int result = new NoOfProvinces08().numProvinces(adj);
        System.out.println("No of provinces :: " + result);
    }
}
