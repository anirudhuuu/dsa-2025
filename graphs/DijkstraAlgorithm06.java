package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Dijkstra's Algorithm
 * =====================
 * Dijkstra's algorithm is a graph search algorithm that finds the shortest path
 * between nodes in a graph.
 * <p>
 * Built using "Priority Queue" (Min Heap) and Adjacency List.
 * <p>
 * Time Complexity: O(E log V)
 * where E is the number of edges and V is the number of vertices
 * <p>
 * Space Complexity: O(V)
 * for the priority queue and distances array
 */
public class DijkstraAlgorithm06 {
    static class Pair implements Comparable<Pair> {
        int node, distance;

        Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }

        public int compareTo(Pair other) {
            return this.distance - other.distance;
        }
    }

    int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // min heap
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        // distances
        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // distance of source node
        dist[S] = 0;

        // initialize min-heap with first pair of value
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            int distance = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            // explore all the nodes of the removed value
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjacentNode = adj.get(node).get(i).get(0);

                if (distance + edgeWeight < dist[adjacentNode]) {
                    dist[adjacentNode] = distance + edgeWeight;

                    pq.add(new Pair(dist[adjacentNode], adjacentNode));
                }
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
        DijkstraAlgorithm06 solver = new DijkstraAlgorithm06();
        int[] distances = solver.dijkstra(V, adj, S);

        // Print shortest distances from source to all nodes
        System.out.println("Shortest distances from node " + S + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " : " + distances[i]);
        }
    }
}
