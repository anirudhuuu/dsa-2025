package basics.language;

/**
 * Given an integer age, print on the screen:
 * - Adult if age >= 18
 * - Teen if age < 18
 */
public class IfElseAdultTeen {
    public void isAdult(int age) {
        if (age >= 18) {
            System.out.println("Adult");
        } else {
            System.out.println("Teen");
        }
    }
}
