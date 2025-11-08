package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Number of islands
 * ==================
 * Given a grid of size N x M (N is the number of rows and M is the number of
 * columns in the grid) consisting of '0's (Water) and '1's(Land). Find the
 * number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically or diagonally i.e., in all 8 directions.
 * <p>
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */
public class NumberOfIslands09 {
    void bfs(int i, int j, boolean[][] visited, char[][] grid) {
        visited[i][j] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        // Dimensions of grid
        int n = grid.length;
        int m = grid[0].length;

        while (!queue.isEmpty()) {
            // Take first element in the queue to process
            int[] cell = queue.poll();

            int row = cell[0];
            int column = cell[1];

            // Traverse in all 8 directions of a given node
            for (int deltaRow = -1; deltaRow <= 1; deltaRow++) {
                for (int deltaColumn = -1; deltaColumn <= 1; deltaColumn++) {
                    int neighbourRow = row + deltaRow;
                    int neighbourColumn = column + deltaColumn;

                    if (neighbourRow >= 0
                            && neighbourRow < n
                            && neighbourColumn >= 0
                            && neighbourColumn < m
                            && grid[neighbourRow][neighbourColumn] == '1'
                            && !visited[neighbourRow][neighbourColumn]
                    ) {
                        visited[neighbourRow][neighbourColumn] = true;
                        queue.add(new int[]{neighbourRow, neighbourColumn});
                    }
                }
            }
        }
    }

    int numIslands(char[][] grid) {
        int n = grid.length; // rows
        int m = grid[0].length; // columns

        // replica of input to keep track of visited nodes
        boolean[][] visited = new boolean[n][m];

        int numberOfIslands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // not visited until now and node is '1'
                if (!visited[i][j] && grid[i][j] == '1') {
                    numberOfIslands += 1;
                    bfs(i, j, visited, grid);
                }
            }
        }

        return numberOfIslands;
    }

    static void main() {
        char[][] grid = {
                {'1', '0', '0', '0', '1'},
                {'0', '1', '0', '1', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '1', '0', '1', '0'}
        };

        int result = new NumberOfIslands09().numIslands(grid);
        System.out.println("Number of Islands :: " + result);
    }
}
