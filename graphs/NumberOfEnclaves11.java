package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves11 {
    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int[][] visited = new int[n][m];

        // find all boundary islands that are 1 (land)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // first row, first column, last row, last column
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        queue.add(new Pair(i, j));
                        visited[i][j] = 1;
                    }
                }
            }
        }

        // find islands that are connected to boundary nodes
        // check the values in queue one-by-one in all 4 directions
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;

            queue.poll();

            for (int i = 0; i < 4; i++) {
                int newRow = row + deltaRow[i];
                int newCol = col + deltaCol[i];

                if (newRow >= 0 && newRow < n
                        && newCol >= 0 && newCol < m
                        && visited[newRow][newCol] == 0
                        && grid[newRow][newCol] == 1
                ) {
                    queue.add(new Pair(newRow, newCol));
                    visited[newRow][newCol] = 1;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    count += 1;
                }
            }
        }
        return count;
    }

    static void main() {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        int result = new NumberOfEnclaves11().numberOfEnclaves(grid);
        System.out.println("Number of Enclaves :: " + result);
    }
}
