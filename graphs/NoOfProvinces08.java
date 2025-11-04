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
 * 
 * A province is a group of directly or indirectly connected cities and no other
 * cities outside of the group.
 */
public class NoOfProvinces08 {
    public void dfs(int node, List<Integer> adjList[], boolean[] visited) {
        visited[node] = true;

        for (int neighbour : adjList[node]) {
            if (visited[neighbour] == false) {
                dfs(neighbour, adjList, visited);
            }
        }
    }

    public int numProvinces(int[][] adj) {
        // no of nodes
        int V = adj.length;

        // keeping track of visited nodes
        boolean[] visited = new boolean[V];

        // convert adjacency matrix to adjacency list
        List<Integer>[] adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj[i][j] == 1 && i != j) {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }

        int noOfProvinces = 0;

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                noOfProvinces += 1;
                dfs(i, adjList, visited);
            }
        }

        return noOfProvinces;
    }

    public static void main(String[] args) {
        int[][] adj = {
                { 1, 0, 0, 1 },
                { 0, 1, 1, 0 },
                { 0, 1, 1, 0 },
                { 1, 0, 0, 1 }
        };
        NoOfProvinces08 solver = new NoOfProvinces08();
        int result = solver.numProvinces(adj);
        System.out.println(result);
    }
}
