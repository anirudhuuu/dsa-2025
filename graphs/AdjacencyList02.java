package graphs;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Adjacency List representation of a graph
 * ==========================================
 * Space Complexity: O(N + E)
 * - O(N) for storing N vertex lists
 * - O(E) for directed edges
 * - O(2*E) for undirected edges (because each edge appears twice)
 *
 * This representation is much more efficient than an adjacency matrix for
 * sparse graphs. The adjacency matrix always consumes O(N²) space, even when
 * most entries are unused.
 */
public class AdjacencyList02 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        // number of nodes
        int N = 5;

        // number of edges
        int M = 6;

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(N + 1);

        // add (N + 1) array lists into it at each index
        for (int i = 0; i <= N; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Adding edges based on 1-based indexing manually
        // Edge 1-2
        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);

        // Edge 1-3
        adjacencyList.get(1).add(3);
        adjacencyList.get(3).add(1);

        // Edge 2-4
        adjacencyList.get(2).add(4);
        adjacencyList.get(4).add(2);

        // Edge 2-5
        adjacencyList.get(2).add(5);
        adjacencyList.get(5).add(2);

        // Edge 3-4
        adjacencyList.get(3).add(4);
        adjacencyList.get(4).add(3);

        // Edge 4-5
        adjacencyList.get(4).add(5);
        adjacencyList.get(5).add(4);

        /*
         * Taking M edge inputs
         * -----------------------
         * for (int i = 0; i < M; i++) {
         *    int u = sc.nextInt();
         *    int v = sc.nextInt();
         *
         *    // add edges between two nodes
         *    adjacencyList.get(u).add(v);
         *    adjacencyList.get(v).add(u);
         * }
         */

        // Print adjacency list
        for (int i = 1; i <= N; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                System.out.print(adjacencyList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
