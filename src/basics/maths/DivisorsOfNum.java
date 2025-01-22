package basics.maths;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer n. You need to find all the divisors of n.
 * Return all the divisors of n as an array or list in a sorted order.
 * <p>
 * A number which completely divides another number is called it's divisor.
 */
public class DivisorsOfNum {
    public int[] divisors(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(val -> val).toArray();
    }
}
