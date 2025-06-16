package arrays.leetcode;

/**
 * Island Perimeter
 * ==================
 * You are given row x col grid representing a map where
 * grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * 
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly one
 * island (i.e., one or more connected land cells).
 * 
 * The island doesn't have "lakes", meaning the water inside isn't connected
 * to the water around the island. One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100. Determine
 * the perimeter of the island.
 * 
 * Time Complexity: O(m × n) — visits each cell once.
 * Space Complexity: O(1) — uses constant extra space.
 */
class IslandPerimeter {
    int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    // left of the land
                    if (j == 0 || grid[i][j - 1] == 0) {
                        perimeter += 1;
                    }

                    // top of the land
                    if (i == 0 || grid[i - 1][j] == 0) {
                        perimeter += 1;
                    }

                    // right of the land
                    if (j == grid[i].length - 1 || grid[i][j + 1] == 0) {
                        perimeter += 1;
                    }

                    // bottom of the land
                    if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                        perimeter += 1;
                    }
                }
            }
        }

        return perimeter;
    }
}
