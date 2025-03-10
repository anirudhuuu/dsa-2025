package arrays.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the row number n
 * Print the n -th row of Pascal’s triangle
 */
public class PascalsTriangle2 {
    // Brute force algorithm
    long nCr(int n, int r) {
        if (r > (n - r)) {
            r = n - r;
        }

        long result = 1;

        for (int i = 0; i < r; i++) {
            result = result * (n - i);
            result = result / (i + 1);
        }

        return result;
    }

    long[] pascalTriangleRowBrute(int rowNumber) {
        int columns = rowNumber;
        List<Long> result = new ArrayList<>();

        for (int i = 1; i <= columns; i++) {
            result.add(nCr(rowNumber - 1, i - 1));
        }

        return result.stream().mapToLong(val -> val).toArray();
    }

    // Optimal solution
    long[] pascalTriangleRow(int rowNumber) {
        List<Long> result = new ArrayList<>();

        long answer = 1;
        result.add(answer);

        for (int col = 1; col < rowNumber; col++) {
            answer = answer * (rowNumber - col);
            answer = answer / col;

            result.add(answer);
        }

        return result.stream().mapToLong(val -> val).toArray();
    }
}
