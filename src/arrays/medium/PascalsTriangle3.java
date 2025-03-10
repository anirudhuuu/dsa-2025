package arrays.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the row number, print the Pascal’s
 * triangle till the row number
 */
public class PascalsTriangle3 {
    List<Long> getPascalTriangleRow(int rowNumber) {
        List<Long> result = new ArrayList<>();

        long answer = 1;
        result.add(answer);

        for (int col = 1; col < rowNumber; col++) {
            answer = answer * (rowNumber - col);
            answer = answer / col;

            result.add(answer);
        }

        return result;
    }

    List<List<Long>> pascalTriangle(int rowNumber) {
        List<List<Long>> result = new ArrayList<>();

        for (int i = 1; i <= rowNumber; i++) {
            result.add(getPascalTriangleRow(i));
        }

        return result;
    }
}
