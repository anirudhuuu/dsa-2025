package greedy;

import java.util.Arrays;

/**
 * Given an 2D array Jobs of size Nx3, where
 * Jobs[i][0] represents JobID,
 * Jobs[i][1] represents Deadline,
 * Jobs[i][2] represents Profit associated with that job.
 * <p>
 * Each Job takes 1 unit of time to complete and only one job can be scheduled at a time.
 * <p>
 * The profit associated with a job is earned only if it
 * is completed by its deadline. Find the number of jobs and maximum profit.
 */
public class JobSequencing {
    public static int[] jobScheduling(int[][] jobs) {
        // Sort jobs based on profit in descending order
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);

        // Total jos
        int n = jobs.length;

        int[] hash = new int[n];
        Arrays.fill(hash, -1);

        // Initialise counter
        int count = 0;

        // Initialize the total profit earned
        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = jobs[i][1] - 1; j >= 0; j--) {
                if (hash[j] == -1) {
                    // Count of selected jobs
                    count += 1;

                    // Mark the job as selected
                    hash[j] = jobs[i][0];

                    // Update the total profit
                    totalProfit += jobs[i][2];

                    break;
                }
            }
        }

        return new int[]{count, totalProfit};
    }

    public static void main(String[] args) {

    }
}
