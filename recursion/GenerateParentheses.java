package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 * =====================
 * Given an integer n.Generate all possible combinations of well-formed
 * parentheses of length 2 x N.
 */
public class GenerateParentheses {
    public static List<String> paranthesis(int index, String str, int opening, int closing, List<String> result,
            int N) {
        if (opening > N || closing > N) {
            return result;
        }

        if (opening + closing == 2 * N && opening == closing) {
            result.add(str);
            return result;
        }

        paranthesis(index + 1, str + "(", opening + 1, closing, result, N);

        if (opening > closing) {
            paranthesis(index + 1, str + ")", opening, closing + 1, result, N);
        }

        return result;
    }

    public static List<String> generateParenthesis(int n) {
        return paranthesis(0, "", 0, 0, new ArrayList<>(), n);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
    }
}
