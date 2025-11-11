package graphs;

import java.util.Scanner;

/*
 * Adjacency Matrix representation of a graph
 * ============================================
 * Time Complexity: O(N²)
 * - Requires an N x N matrix
 * - Can represent both directed and undirected graphs
 * - Efficient for dense graphs, but wasteful for sparse graphs
 *
 * Space Complexity: O(N²)
 * - An adjacency matrix always consumes N² space
 * - Even if the number of edges is small, all N² entries must be stored
 * - Therefore preferred only for dense graphs where many edges exist
 */
public class AdjacencyMatrix01 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        // number of nodes
        int N = sc.nextInt();

        // number of edges
        int M = sc.nextInt();

        // Adjacency Matrix for undirected graph
        int[][] adjacencyMatrix = new int[N + 1][N + 1];

        // Adding edges based on 1-based indexing manually
        // Edge 1-2
        adjacencyMatrix[1][2] = 1;
        adjacencyMatrix[2][1] = 1;

        // Edge 1-3
        adjacencyMatrix[1][3] = 1;
        adjacencyMatrix[3][1] = 1;

        // Edge 2-4
        adjacencyMatrix[2][4] = 1;
        adjacencyMatrix[4][2] = 1;

        // Edge 3-4
        adjacencyMatrix[3][4] = 1;
        adjacencyMatrix[4][3] = 1;

        // Edge 2-5
        adjacencyMatrix[2][5] = 1;
        adjacencyMatrix[5][2] = 1;

        // Edge 4-5
        adjacencyMatrix[4][5] = 1;
        adjacencyMatrix[5][4] = 1;

        /*
         * Taking M edge inputs
         * ----------------------
         * for (int i = 0; i < M; i++) {
         *    int u = sc.nextInt();
         *    int v = sc.nextInt();
         *
         *    // add edges between two nodes
         *    adjacencyMatrix[u][v] = 1;
         *    adjacencyMatrix[v][u] = 1;
         * }
         */

        // Print adjacency matrix
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
