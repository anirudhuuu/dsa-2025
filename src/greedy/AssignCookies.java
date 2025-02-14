package greedy;

import java.util.Arrays;

/**
 * Consider a scenario where a teacher wants to distribute cookies
 * to students, with each student receiving at most one cookie.
 * <p>
 * Given two arrays, Student and Cookie, the ith value in the Student array
 * describes the minimum size of cookie that the ith student can be assigned.
 * <p>
 * The jth value in the Cookie array represents the size of the jth cookie.
 * <p>
 * If Cookie[j] >= Student[i], the jth cookie can be assigned to the ith student.
 * <p>
 * Maximize the number of students assigned with cookies and output the maximum number.
 */
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
