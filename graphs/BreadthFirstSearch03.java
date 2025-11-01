package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch03 {
    /**
     * @param V             no of nodes in graph
     * @param adjacencyList adjacency list
     * @return bfs traversal
     */
    ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adjacencyList) {
        ArrayList<Integer> bfsTraversedResult = new ArrayList<>();

        // define a queue and array of visited
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];

        // pass the starting node into queue
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            Integer element = queue.poll();
            bfsTraversedResult.add(element);

            // Who are the neighbours of removed element?
            for (Integer neighbor : adjacencyList.get(element)) {
                if (visited[neighbor] == false) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return bfsTraversedResult;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        /**
         * Graph:
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

        // Perform BFS
        ArrayList<Integer> bfs = new BreadthFirstSearch03().bfsOfGraph(10, adj);
        System.out.println("BFS Traversal: " + bfs);
    }
}
