package warm_up;

// Write a function that returns the count of digits in a number
public class CountDigits {
    public static int coutDigits(int n) {
        // when value is 0, that is also a digit
        if (n == 0) {
            return 1;
        }

        int count = 0;

        while (n != 0) {
            count += 1;
            n = n / 10;
        }

        return count;
    }

    public static void main(String[] args) {
        int number = 1938912398;
        System.out.println(coutDigits(number));
    }
}
