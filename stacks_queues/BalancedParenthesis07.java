package stacks_queues;

import java.util.Stack;

/**
 * Balanced Paranthesis
 * =====================
 * Given string str containing just the characters '(', ')', '{', '}', '[' and
 * ']', check if the input string is valid and return true if the string is
 * balanced otherwise return false.
 */
public class BalancedParenthesis07 {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char topElement = stack.pop();

                if ((topElement == '(' && ch != ')') ||
                        (topElement == '[' && ch != ']') ||
                        (topElement == '{' && ch != '}')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BalancedParenthesis07 bp = new BalancedParenthesis07();

        String str1 = "()[{}()]";
        System.out.println("Input: str = \"" + str1 + "\"");
        System.out.println("Output: " + bp.isValid(str1));

        String str2 = "[()";
        System.out.println("Input: str = \"" + str2 + "\"");
        System.out.println("Output: " + bp.isValid(str2));
    }
}
