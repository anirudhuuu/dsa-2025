package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Dijkstra's Algorithm
 * =====================
 * Dijkstra's algorithm is a graph search algorithm that finds the shortest path
 * between nodes in a graph.
 * <p>
 * Built using "Set" and Adjacency List.
 * <p>
 * Time Complexity: O(E log V)
 * where E is the number of edges and V is the number of vertices
 * <p>
 * Space Complexity: O(V)
 * for the set and distances array
 */
public class DijkstraAlgorithm07 {
    int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // set
        TreeSet<int[]> set = new TreeSet<int[]>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]); // Compare by distance
            return Integer.compare(a[1], b[1]); // If distances are equal, compare by node
        });

        // distances
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // distance of source node
        dist[S] = 0;
        set.add(new int[]{0, S});

        while (!set.isEmpty()) {
            int[] current = set.pollFirst();
            int distance = current[0];
            int node = current[1];

            // explore all the nodes of the removed value
            for (ArrayList<Integer> neighbor : adj.get(node)) {
                int adjacentNode = neighbor.get(0);
                int edgeWeight = neighbor.get(1);

                if (distance + edgeWeight < dist[adjacentNode]) {
                    set.remove(new int[]{dist[adjacentNode], adjacentNode});

                    dist[adjacentNode] = distance + edgeWeight;

                    set.add(new int[]{dist[adjacentNode], adjacentNode});
                }
            }
        }

        // unreachable nodes
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = 1000000000;
            }
        }

        return dist;
    }

    static void main() {
        int V = 6; // No of nodes
        int S = 0; // Source node

        // Construct adjacency list
        // adj.get(u).get(i).get(0) is the adjacent node v
        // adj.get(u).get(i).get(1) is the edge weight from u to v
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Edge 0-1 (weight 4)
        ArrayList<Integer> edge01 = new ArrayList<>();
        edge01.add(1);
        edge01.add(4);
        adj.get(0).add(edge01);

        // Edge 0-2 (weight 4)
        ArrayList<Integer> edge02 = new ArrayList<>();
        edge02.add(2);
        edge02.add(4);
        adj.get(0).add(edge02);

        // Edge 1-2 (weight 2)
        ArrayList<Integer> edge12 = new ArrayList<>();
        edge12.add(2);
        edge12.add(2);
        adj.get(1).add(edge12);

        // Edge 2-3 (weight 3)
        ArrayList<Integer> edge23 = new ArrayList<>();
        edge23.add(3);
        edge23.add(3);
        adj.get(2).add(edge23);

        // Edge 3-5 (weight 2)
        ArrayList<Integer> edge35 = new ArrayList<>();
        edge35.add(5);
        edge35.add(2);
        adj.get(3).add(edge35);

        // Edge 4-5 (weight 3)
        ArrayList<Integer> edge45 = new ArrayList<>();
        edge45.add(5);
        edge45.add(3);
        adj.get(4).add(edge45);

        // Edge 2-5 (weight 6)
        ArrayList<Integer> edge25 = new ArrayList<>();
        edge25.add(5);
        edge25.add(6);
        adj.get(2).add(edge25);

        // Edge 2-4 (weight 1)
        ArrayList<Integer> edge24 = new ArrayList<>();
        edge24.add(4);
        edge24.add(1);
        adj.get(2).add(edge24);

        // Run Dijkstra's Algorithm
        int[] distances = new DijkstraAlgorithm07().dijkstra(V, adj, S);

        // Print shortest distances from source to all nodes
        System.out.println("Shortest distances from node " + S + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " : " + distances[i]);
        }
    }
}
