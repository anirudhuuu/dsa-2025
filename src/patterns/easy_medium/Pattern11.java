package patterns.easy_medium;

public class Pattern11 {
    void pattern11(int n) {
        for (int i = 1; i <= n; i++) {
            boolean value = i % 2 != 0;

            for (int j = 0; j < i; j++) {
                System.out.print((value ? 1 : 0) + " ");
                value = !value;
            }

            System.out.println();
        }
    }
}
