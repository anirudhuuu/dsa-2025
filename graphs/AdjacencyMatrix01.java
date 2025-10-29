package graphs;

public class AdjacencyMatrix01 {
    public static void main(String[] args) {
        int N = 5;
        int M = 6;

        // N = number of nodes
        // M = number of edges

        // Adjacency Matrix
        int[][] adjacencyMatrix = new int[N + 1][N + 1];

        // Adjacency matrix with values
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }

        // Adding edges based on 1-based indexing
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

        // Print adjacency matrix
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
