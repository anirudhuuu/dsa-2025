package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Rotten Oranges
 * ===============
 * Given an n x m grid, where each cell has the following values:
 * <p>
 * 2 - represents a rotten orange
 * 1 - represents a Fresh orange
 * 0 - represents an Empty Cell
 * Every minute, if a fresh orange is adjacent to a rotten orange in
 * 4-direction ( upward, downwards, right, and left ) it becomes rotten.
 * <p>
 * Return the minimum number of minutes required such that none of
 * the cells has a Fresh Orange. If it's not possible, return -1.
 */
public class RottenOranges12 {
    int[] deltaRow = {-1, 0, 1, 0};
    int[] deltaColumn = {0, 1, 0, -1};

    boolean isValid(int newRow, int newCol, int rows, int cols) {
        if (newRow < 0 || newRow >= rows) {
            return false;
        }

        if (newCol < 0 || newCol >= cols) {
            return false;
        }

        return true;
    }

    int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // time taken to rotten all oranges
        int time = 0;

        int totalOranges = 0;
        int rottenOranges = 0;

        // keep all rotten oranges in queue to process BFS
        Queue<int[]> queue = new LinkedList<>();

        // traverse entire input grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // all oranges
                if (grid[i][j] != 0) {
                    totalOranges += 1;
                }

                // rotten oranges
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // perform BFS
        while (!queue.isEmpty()) {
            int k = queue.size();

            rottenOranges += k;

            while (k > 0) {
                int[] cell = queue.poll();

                int row = cell[0];
                int column = cell[1];

                // check in all 4 directions
                for (int i = 0; i < 4; i++) {
                    int newRow = row + deltaRow[i];
                    int newColumn = column + deltaColumn[i];

                    if (isValid(newRow, newColumn, n, m) && grid[newRow][newColumn] == 1) {
                        grid[newRow][newColumn] = 2;
                        queue.offer(new int[]{newRow, newColumn});
                    }
                }

                k--;
            }

            if (!queue.isEmpty()) {
                time += 1;
            }
        }

        if (totalOranges == rottenOranges) {
            return time;
        }

        return -1;
    }

    static void main() {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println("The minimum number of minutes required for all oranges to rotten are: " + new RottenOranges12().orangesRotting(grid));
    }
}
