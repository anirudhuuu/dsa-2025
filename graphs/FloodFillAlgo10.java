package graphs;

/**
 * Flood fill algorithm
 * ======================
 * An image is represented by a 2-D array of integers, each integer
 * representing the pixel value of the image. Given a coordinate (sr, sc)
 * representing the starting pixel (row and column) of the flood fill,
 * and a pixel value newColor, "flood fill" the image.
 * <p>
 * To perform a flood fill, consider the starting pixel, plus any pixels
 * connected 4-directionally to the starting pixel of the same color as the
 * starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color as the starting pixel), and so on. Replace the
 * color of all the aforementioned pixels with the newColor.
 * <p>
 * Time Complexity: O(N * M)
 * Space Complexity: O(N * M) + O(N * M) for stack
 */
public class FloodFillAlgo10 {
    void dfs(int row, int column, int[][] answer, int[][] image, int newColor, int[] deltaRow, int[] deltaColumn, int initialColor) {
        // fill the item with new color
        answer[row][column] = newColor;

        int n = image.length;
        int m = image[0].length;

        // search in 4 neighboring directions
        for (int i = 0; i < 4; i++) {
            int newRow = row + deltaRow[i];
            int newColumn = column + deltaColumn[i];

            if (newRow >= 0 && newRow < n
                    && newColumn >= 0 && newColumn < m
                    && image[newRow][newColumn] == initialColor
                    && answer[newRow][newColumn] != newColor
            ) {
                dfs(newRow, newColumn, answer, image, newColor, deltaRow, deltaColumn, initialColor);
            }
        }
    }

    int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initialColor = image[sr][sc];

        if (newColor == initialColor) {
            return image;
        }

        // keep track of visited node + transformed image
        int[][] answer = image;

        // start value root is colored with new color
        answer[sr][sc] = newColor;

        // change in row/column to check in 4 directions
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaColumn = {0, 1, 0, -1};

        dfs(sr, sc, answer, image, newColor, deltaRow, deltaColumn, initialColor);

        return answer;
    }

    static void main() {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        int[][] answer = new FloodFillAlgo10().floodFill(image, sr, sc, newColor);
        for (int[] rowVal : answer) {
            for (int colVal : rowVal) {
                System.out.print(colVal + " ");
            }
            System.out.println();
        }
    }
}
