import java.util.Scanner;

public class Basics {
    public static void main(String[] args) {
        // the following line prints "Hello, World!" to the console
        System.out.println("Hello, World!");

        /**
         * Multi-line comments
         */

        // Data types
        // Basic data types in Java:
        byte num1 = 100; // -128 to 127 occupies 8 bits (1 byte)
        short num2 = 1000; // -32768 to 32767 occupies 16 bits (2 bytes)
        int num3 = 100000; // -2^31 to 2^31-1 occupies 32 bits (4 bytes)
        long num4 = 1000000000000000000L; // -2^63 to 2^63-1 occupies 64 bits (8 bytes)

        float num5 = 100.5f; // 32 bits (4 bytes)
        double num6 = 100.5; // 64 bits (8 bytes)

        char num7 = 'A'; // 16 bits (2 bytes)

        boolean num8 = true; // 1 bit (1 byte)

        // Arithmetic operators
        int a = 10;
        int b = 20;

        int c = a + b;
        System.out.println(c); // 30

        c = a - b;
        System.out.println(c); // -10

        c = a * b;
        System.out.println(c); // 200

        c = a / b;
        System.out.println(c); // 0 (integer division, result truncated)

        c = a % b;
        System.out.println(c); // 10

        // Relational operators
        System.out.println(a == b); // false
        System.out.println(a != b); // true

        System.out.println(a > b); // false
        System.out.println(a < b); // true

        System.out.println(a >= b); // false
        System.out.println(a <= b); // true

        // Logical operators
        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println(bool1 && bool2); // false
        System.out.println(bool1 || bool2); // true
        System.out.println(!bool1); // false

        // Assignment operators
        a += b;
        System.out.println(a); // 30

        a -= b;
        System.out.println(a); // 10

        a *= b;
        System.out.println(a); // 200

        a /= b;
        System.out.println(a); // 10 (integer division, 200/20 = 10)

        a %= b;
        System.out.println(a); // 10 (10 % 20 = 10)

        // Increment and decrement operators
        a++;
        System.out.println(a); // 11
        a--;
        System.out.println(a); // 10

        // Bitwise operators
        System.out.println(a & b); // 0 (bitwise AND)
        System.out.println(a | b); // 30 (bitwise OR)
        System.out.println(a ^ b); // 30 (bitwise XOR)
        System.out.println(~a); // -11 (bitwise NOT)
        System.out.println(a << b); // 10485760 (left shift: 10 << 20)
        System.out.println(a >> b); // 0 (right shift: 10 >> 20)
        System.out.println(a >>> b); // 0 (unsigned right shift: 10 >>> 20)

        // Ternary operator
        int x = 10;
        int y = 20;
        int z = (x > y) ? x : y;
        System.out.println(z); // 20

        // String methods
        String name = "Anirudh";
        System.out.println(name.charAt(0)); // A
        System.out.println(name.substring(0, 3)); // Ani
        System.out.println(name.length()); // 7

        String lastName = "Jwala";
        name = name + " " + lastName; // ends up in a new memory location (Immutable)
        System.out.println(name); // Anirudh Jwala

        System.out.println(name.equals("Anirudh")); // true
        System.out.println(name.equalsIgnoreCase("anirudh")); // true

        // == v/s equals()
        System.out.println(name == "Anirudh Jwala"); // false: == checks for reference equality
        System.out.println(name.equals("Anirudh Jwala")); // true: equals() checks for value equality

        // Input and Output
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String inputName = scanner.nextLine();
        System.out.println("Hello, " + inputName + "!");

        // nextInt(), nextDouble(), nextLine(), next(), nextBoolean()

        scanner.close();

        // Type casting
        // Implicit type casting
        int num = 10;
        double numDouble = num;
        System.out.println(numDouble); // 10.0

        // Explicit type casting
        double anotherNumDouble = 10.5;
        int anotherNum = (int) anotherNumDouble;
        System.out.println(anotherNum); // 10

        // final keyword
        final int finalNum = 10;
        System.out.println(finalNum); // 10
        // finalNum = 20; error: cannot assign a value to final variable finalNum

        // Arrays
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        System.out.println(arr[0]); // 1
        System.out.println(arr.length); // 5 (length is a property of the array)

        // for-each loop
        for (int i : arr) {
            System.out.print(i + " "); // 1 2 3 4 5
        }

        // 2-D Array (like a matrix)
        int[][] arr2D = new int[2][2];
        arr2D[0][0] = 1;
        arr2D[0][1] = 2;
        arr2D[1][0] = 3;
        arr2D[1][1] = 4;

        System.out.println(arr2D[0][0]); // 1

        // Given an age, print "adult" if age>=18, or print "Teen"
        int age = 18;
        if (age >= 18) {
            System.out.println("Adult");
        } else {
            System.out.println("Teen");
        }

        /**
         * Given marks of a student, tell us the grade
         * he is getting following the rules:
         * - Grade A if marks>=90
         * - Grade B if marks>=70
         * - Grade C if marks>=50
         * - Grade D if marks>=35
         * - Fail, otherwise.
         */
        int marks = 90;
        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 70) {
            System.out.println("Grade B");
        } else if (marks >= 50) {
            System.out.println("Grade C");
        } else if (marks >= 35) {
            System.out.println("Grade D");
        } else {
            System.out.println("Fail");
        }

        /**
         * You are given three integers: a, b, and c.
         * print which of these integers is the largest.
         * If two or more integers are equal and are the largest,
         * the program should indicate that as well.
         */
        int n1 = 10;
        int n2 = 20;
        int n3 = 30;
        if (n1 > n2 && n1 > n3) {
            System.out.println("n1 is the largest");
        } else if (n2 > n1 && n2 > n3) {
            System.out.println("n2 is the largest");
        } else {
            System.out.println("n3 is the largest");
        }

        // Given the day number print which day it is of the week
        // assume week starts from Monday ends on Sunday
        int day = 1;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid");
        }
    }
}
