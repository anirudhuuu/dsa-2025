package greedy;

/**
 * Each lemonade at a booth sells for $5. Consumers are lining up to place individual orders,
 * following the billing order. Every consumer will purchase a single lemonade and may pay
 * with a $5, $10, or $20 bill. Each customer must receive the appropriate change so that
 * the net transaction is $5. Initially, there is no change available.
 * <p>
 * Determine if it is possible to provide the correct change to every customer.
 * Return true if the correct change can be given to every customer, and false otherwise.
 * <p>
 * Given an integer array bills, where bills[i] is the bill the ith customer pays,
 * return true if the correct change can be given to every customer, and false otherwise.
 */
public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        // int twenty = 0; no need to keep track

        for (int bill : bills) {
            if (bill == 5) {
                fives = fives + 1;
            } else if (bill == 10) {
                if (fives > 0) {
                    fives = fives - 1;
                    tens = tens + 1;
                } else {
                    return false;
                }
            } else {
                if (tens > 0 && fives > 0) {
                    tens = tens - 1;
                    fives = fives - 1;
                } else if (fives >= 3) {
                    fives = fives - 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 5, 20};

        System.out.println("Can we give correct change to every customer? " + lemonadeChange(bills));
    }
}
