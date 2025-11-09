package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Distance of nearest cell having one
 * ======================================
 * Given a binary grid of N x M. Find the distance of the nearest 1 in the grid for each cell.
 * <p>
 * The distance is calculated as |i1 - i2| + |j1 - j2|, where i1, j1 are the row number
 * and column number of the current cell, and i2, j2 are the row number and column number
 * of the nearest cell having value 1.
 */
public class DistanceOfNearestCellHavingOne13 {
    class Node {
        int row;
        int column;
        int distance;

        Node(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }
    }

    int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] distances = new int[n][m];
        int[][] visited = new int[n][m];

        Queue<Node> queue = new LinkedList<>();

        // find all the places where input grid has "1"
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // distance to nearest 1 is the node itself, so 0
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = 1;
                } else {
                    visited[i][j] = 0;
                }
            }
        }

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        // perform BFS on all nodes present in queue on 4 directions
        while (!queue.isEmpty()) {
            Node cell = queue.poll();

            int row = cell.row;
            int column = cell.column;
            int distance = cell.distance;

            distances[row][column] = distance;

            // for the node picked, check in 4 directions
            for (int i = 0; i < 4; i++) {
                int newRow = row + deltaRow[i];
                int newColumn = column + deltaCol[i];

                if (newRow >= 0 && newRow < n
                        && newColumn >= 0 && newColumn < m
                        && visited[newRow][newColumn] == 0
                ) {
                    visited[newRow][newColumn] = 1;
                    queue.add(new Node(newRow, newColumn, distance + 1));
                }
            }
        }

        return distances;
    }

    static void main() {
        int[][] grid = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 0, 0},
        };

        System.out.println("Distance of nearest cell having one :: ");
        int[][] result = new DistanceOfNearestCellHavingOne13().nearest(grid);

        for (int[] rows : result) {
            for (int columns : rows) {
                System.out.print(columns + " ");
            }
            System.out.println();
        }
    }
}
