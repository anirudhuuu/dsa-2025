package arrays.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an M * N matrix, print the elements in a clockwise
 * spiral manner. Return an array with the elements in the
 * order of their appearance when printed in a spiral manner.
 */
public class SpiralMatrix {
    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = m - 1;

        int top = 0;
        int bottom = n - 1;

        while (top <= bottom && left <= right) {
            // Left to Right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top += 1;

            // Top to Bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right -= 1;

            if (top <= bottom) {
                // Right to Left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom -= 1;
            }

            if (left <= right) {
                // Bottom to Top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left += 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(arr));
    }
}
