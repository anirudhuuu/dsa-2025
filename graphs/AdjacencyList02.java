package graphs;

import java.util.ArrayList;

/**
 * Adjacency List representation of a graph
 * 
 * Space Complexity: O(N + E)
 * - O(N) for storing N vertex lists
 * - O(2E) for undirected edges (or O(E) for directed)
 */
public class AdjacencyList02 {
    public static void main(String[] args) {
        int N = 5;
        int M = 6;

        // N = number of nodes
        // M = number of edges

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();

        // add N+1 array lists into it
        for (int i = 0; i <= N; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }

        // Adding edges
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
