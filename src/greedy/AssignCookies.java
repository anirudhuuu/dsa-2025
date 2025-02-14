package greedy;

import java.util.Arrays;

public class AssignCookies {
    public static int findMaximumCookieStudents(int[] students, int[] cookies) {
        int n = students.length;
        int m = cookies.length;

        int l = 0;
        int r = 0;

        // Sort the arrays
        Arrays.sort(students);
        Arrays.sort(cookies);

        while (l < n && r < m) {
            if (students[l] <= cookies[r]) {
                l += 1;
            }

            r += 1;
        }

        return l;
    }

    public static void main(String[] args) {
        int[] students = {4, 5, 1};
        int[] cookies = {6, 4, 2};

        System.out.println("Maximum no of cookies that could be assigned to students :: " + findMaximumCookieStudents(students, cookies));
    }
}
