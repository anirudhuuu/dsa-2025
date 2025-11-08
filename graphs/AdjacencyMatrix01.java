package graphs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Adjacency Matrix representation of a graph
 * <p>
 * Space Complexity: O(N²)
 * - Always requires N x N matrix
 * - Works for both directed and undirected graphs
 * - Good for dense graphs, but wasteful for sparse ones
 * <p>
 * Space Complexity: O(N²) The space needed to represent a graph using its adjacency matrix
 * is N² locations. It is a costly method as n² locations are consumed. It is preferred for
 * dense graphs where the number of edges is more.
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

        // Adjacency matrix with default value of '0' on all rows
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            Arrays.fill(adjacencyMatrix[i], 0);
        }

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

        // Taking M edge inputs
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            // add edges between two nodes
            adjacencyMatrix[u][v] = 1;
            adjacencyMatrix[v][u] = 1;
        }

        // Print adjacency matrix
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
