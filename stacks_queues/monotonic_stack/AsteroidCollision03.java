package monotonic_stack;

import java.util.Stack;

/**
 * Asteroid Collision
 * =====================
 * Given an array of integers asteroids, where each integer represents an
 * asteroid in a row, determine the state of the asteroids after all collisions.
 * In this array, the absolute value represents the size of the asteroid, and
 * the sign represents its direction (positive meaning right and negative
 * meaning left). All asteroids move at the same speed.
 * 
 * When two asteroids meet, the smaller one will explode. If they are the same
 * size, both will explode. Asteroids moving in the same direction will never
 * meet.
 */
public class AsteroidCollision03 {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                // asteroid direction moving to the right, no collision, look for left moving
                stack.push(asteroid);
            } else {
                // asteroid direction moving to the left, possible collision with a right one
                boolean asteroidDestroyed = false;

                // check if there is a possible collision
                while (!stack.isEmpty() && stack.peek() > 0) {
                    // stack has elements & they are moving to right (so we are checking)
                    int topAsteroid = stack.peek();

                    if (Math.abs(asteroid) > topAsteroid) {
                        // it shall destroy the value on top
                        stack.pop();
                    } else if (Math.abs(asteroid) == topAsteroid) {
                        stack.pop();
                        asteroidDestroyed = true;
                        break;
                    } else {
                        asteroidDestroyed = true;
                        break;
                    }
                }

                // asteroid has survived the collision and not destroyed
                if (!asteroidDestroyed) {
                    stack.push(asteroid);
                }
            }
        }

        // left over elements of stack are result
        int[] result = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, -2 };
        int[] result1 = asteroidCollision(arr1);

        for (int val : result1) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[] arr2 = { 10, 20, -10 };
        int[] result2 = asteroidCollision(arr2);

        for (int val : result2) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
