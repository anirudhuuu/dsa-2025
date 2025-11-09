package graphs;

/**
 * Surrounded Regions
 * ===================
 * You are given a matrix mat of size N x M where each cell contains either 'O' or 'X'.
 * Your task is to replace all 'O' cells that are completely surrounded by 'X' with 'X'.
 * <p>
 * Rules:
 * - An 'O' (or a group of connected 'O's) is considered surrounded if
 * it is not connected to any border of the matrix.
 * - Two 'O' cells are considered connected if they are adjacent
 * horizontally or vertically (not diagonally).
 * - A region of connected 'O's that touches the border (i.e., first row,
 * last row, first column, or last column) is not surrounded and should not be changed.
 */
public class SurroundedRegions14 {
    void dfs(int row, int column, int[][] visited, char[][] matrix, int[] deltaRow, int[] deltaColumn) {
        visited[row][column] = 1;

        int n = matrix.length;
        int m = matrix[0].length;

        // check in all 4 directions of the node
        for (int i = 0; i < 4; i++) {
            int newRow = row + deltaRow[i];
            int newColumn = column + deltaColumn[i];

            if (newRow >= 0 && newRow < n
                    && newColumn >= 0 && newColumn < m
                    && visited[newRow][newColumn] == 0
                    && matrix[newRow][newColumn] == 'O'
            ) {
                dfs(newRow, newColumn, visited, matrix, deltaRow, deltaColumn);
            }
        }
    }

    char[][] fill(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] visited = new int[n][m];

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        // traverse first row and last row
        for (int j = 0; j < m; j++) {
            // first row
            if (visited[0][j] == 0 && matrix[0][j] == 'O') {
                dfs(0, j, visited, matrix, deltaRow, deltaCol);
            }

            // last row
            if (visited[n - 1][j] == 0 && matrix[n - 1][j] == 'O') {
                dfs(n - 1, j, visited, matrix, deltaRow, deltaCol);
            }
        }

        // traverse first column and last column
        for (int i = 0; i < n; i++) {
            // first row
            if (visited[i][0] == 0 && matrix[i][0] == 'O') {
                dfs(i, 0, visited, matrix, deltaRow, deltaCol);
            }

            // last row
            if (visited[i][m - 1] == 0 && matrix[i][m - 1] == 'O') {
                dfs(i, m - 1, visited, matrix, deltaRow, deltaCol);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && matrix[i][j] == 'O') {
                    matrix[i][j] = 'X';
                }
            }
        }

        return matrix;
    }

    static void main() {
        char[][] matrix = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        char[][] result = new SurroundedRegions14().fill(matrix);
        for (char[] row : result) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
