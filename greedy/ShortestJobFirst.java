package greedy;

import java.util.Arrays;

/**
 * A software engineer is tasked with using the "shortest job first (SJF)"
 * policy to calculate the average waiting time for each process.
 * The shortest job first also known as shortest job next (SJN)
 * scheduling policy selects the waiting process with the least
 * execution time to run next.
 * <p>
 * Given an array of "n" integers representing the burst times
 * of processes, determine the average waiting time for all
 * processes and return the closest whole number that is
 * less than or equal to the result.
 */
public class ShortestJobFirst {
    public static long solve(int[] bt) {
        long waitingTime = 0;
        long totalTime = 0;

        // Sort the burst times so that "shortest" job is executed first
        Arrays.sort(bt);

        for (int time : bt) {
            waitingTime = waitingTime + totalTime;
            totalTime = totalTime + time;
        }

        return waitingTime / bt.length;
    }

    public static void main(String[] args) {
        int[] burstTimes = {1, 2, 3, 4};

        System.out.println("The average waiting time for all processes :: " + solve(burstTimes));
    }
}
