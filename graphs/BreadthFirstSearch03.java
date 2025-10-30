package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch03 {
    /**
     * @param V   no of nodes in graph
     * @param adj adjacency list
     * @return bfs traversal
     */
    ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();

        // visited array to keep track of nodes
        boolean[] visited = new boolean[V];

        // queue that will store the elements level wise
        Queue<Integer> q = new LinkedList<>();

        // Starting point of the BFS traversal
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            // take the first element in the queue
            Integer node = q.poll();

            // add to the result
            bfs.add(node);

            /**
             * get all adjacent nodes of the dequeued node if a adjacency has not been
             * visited, them mark as visited and enqueue it
             */
            for (Integer val : adj.get(node)) {
                if (visited[val] == false) {
                    visited[val] = true;
                    q.add(val);
                }
            }
        }

        return bfs;
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
