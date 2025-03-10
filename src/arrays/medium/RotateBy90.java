package arrays.medium;

/**
 * Given an N * N 2D integer matrix, rotate the
 * matrix by 90 degrees clockwise.
 * <p>
 * The rotation must be done in place, meaning the input
 * 2D matrix must be modified directly.
 */
public class RotateBy90 {
    // Brute force
    void rotateMatrixBrute(int[][] matrix) {
        int n = matrix.length;

        // Store in temporary array
        int[][] result = new int[n][n];

        // Rotate 2D array by 90-degrees
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - i - 1] = matrix[i][j];
            }
        }

        // Output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Optimal solution
    void rotateMatrix(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix across the diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Swap elements across the diagonal
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row of the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                // Swap elements symmetrically
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
