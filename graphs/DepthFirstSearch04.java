package graphs;

import java.util.ArrayList;

public class DepthFirstSearch04 {
    /**
     * @param node          on which we are operating
     * @param visited       list keeping track of what is already operated
     * @param adjacencyList input graph
     * @param result        final output
     */
    void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList, ArrayList<Integer> result) {
        // mark the current operating node as visited
        visited[node] = true;
        result.add(node);

        // find neighbours of operating node
        for (Integer neighbour : adjacencyList.get(node)) {
            if (visited[neighbour] == false) {
                dfs(neighbour, visited, adjacencyList, result);
            }
        }
    }

    /**
     * @param V             no of nodes in graph
     * @param adjacencyList adjacency list
     * @return dfs traversal
     */
    ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adjacencyList) {
        ArrayList<Integer> dfsTraversedResult = new ArrayList<>();
        boolean[] visited = new boolean[V];

        // start DFS from node 1
        // starting node, visited array, adjacency list, final result
        dfs(1, visited, adjacencyList, dfsTraversedResult);

        return dfsTraversedResult;
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

        // Perform DFS
        ArrayList<Integer> dfs = new DepthFirstSearch04().dfsOfGraph(10, adj);
        System.out.println("DFS Traversal: " + dfs);
    }
}
